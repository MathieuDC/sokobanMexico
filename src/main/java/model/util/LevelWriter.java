//  LevelWriter.java
//  Author: Baudorre Grégoire
//  Date : 22/05/2020

package model.util;

import model.level.Level;
import model.levelHandler.LevelHandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LevelWriter {

    private ObjectOutputStream objectOutputStream;

    public LevelWriter() {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("levels/current.ser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(LevelHandler levelHandler){
        try {
            objectOutputStream.writeObject(levelHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
