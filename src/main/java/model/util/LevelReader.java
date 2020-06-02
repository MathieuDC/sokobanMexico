package model.util;

import model.element.FixedElement;
import model.element.MovableElement;
import model.grid.*;
import model.level.Field;
import model.level.Level;
import model.levelHandler.LevelHandler;

import java.io.*;
import java.util.Scanner;

public class LevelReader{

    private FileReader fileReader;

    private Scanner scanner;

    public LevelReader() {
    }

    public Level read(int numLevel) throws IOException {
        initReaders(numLevel);

        Coordinate characterCoord = readCharacterCoord();

        GridFixedElementBuilder gridFixedElementBuilder = new GridFixedElementBuilder();
        GridMovableElementBuilder gridMovableElementBuilder = new GridMovableElementBuilder();

        int c;
        int i = 0;
        int j = 0;
        while((c = fileReader.read()) != -1){
            switch (c){
                case 'W':
                    gridFixedElementBuilder.add(FixedElement.WALL);
                    break;
                case 'F':
                    gridFixedElementBuilder.add(FixedElement.FLOOR);
                    break;
                case 'G':
                    gridFixedElementBuilder.add(FixedElement.GOAL);
                    break;
                case 'N':
                    gridFixedElementBuilder.add(FixedElement.NONE);
                    break;
                case 'B':
                    gridMovableElementBuilder.add(i, j, MovableElement.BOX);
                    gridFixedElementBuilder.add(FixedElement.FLOOR);
                    break;
                case 'P':
                    gridMovableElementBuilder.add(i, j, MovableElement.PLACED_BOX);
                    gridFixedElementBuilder.add(FixedElement.GOAL);
                    break;
                case'\n':
                    i++;
                    j = 0;
                    gridFixedElementBuilder.newLine();
                    break;
                default:
                    throw new IOException("Wrong character"); //TODO Create exception
            }
            if(c != '\n') j++;
        }

        Field field = new Field(characterCoord, gridFixedElementBuilder.build(), gridMovableElementBuilder.build());
        return new Level(field);
    }

    private void initReaders(int numLevel) {
        try {
            String path = "levels/";
            this.fileReader = new FileReader(path + numLevel + ".txt");
            int c = fileReader.read();
            while(c != '\n') c = fileReader.read();
            this.scanner = new Scanner(new FileInputStream(path + numLevel + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Coordinate readCharacterCoord() throws IOException {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.close();
        return new Coordinate(x,y);
    }

    /**
     * Load an ongoing level. If the aren't any, load the first level.
     *
     * @return the ongoing level if existing, otherwise the first level.
     */
    public LevelHandler load(){
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("levels/current.ser"));
        } catch (IOException e) {
            return new LevelHandler();
        }

        try {
            LevelHandler levelHandler = (LevelHandler) objectInputStream.readObject();
            objectInputStream.close();
            return levelHandler;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
