package com.test.astraia;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {
    private FileWriter writer = new FileWriter();

    @Test
    void write() throws IOException {
        String example1 = getContent();

        String path = "src/test/resources/example1.wiki";
        File file = writer.write(path,example1);

        String result;
        FileInputStream fis = new FileInputStream(path);
        DataInputStream reader = new DataInputStream(fis);
        result = reader.readUTF();
        reader.close();

        assertEquals(example1, result);
        file.delete();
    }

    private String getContent() {
        return "The text can start outside a section....\n" +
                "=Build 1234=\n" +
                "==Api component==\n" +
                "'''Date: ''01.04.2015'''''\n" +
                "===Main===\n" +
                "====astraia.jar====\n" +
                "''Built in '''512ms'''''\n" +
                "===Test===\n" +
                "Test performed on the different databases\n" +
                "====Sybase====\n" +
                "=====Preparing DB=====\n" +
                "Done in ''1556ms''\n" +
                "=====JUnits=====\n" +
                "======com.astraia.api.data======\n" +
                "'''Passed:''' All passed!\n" +
                "'''Failed:''' None\n";
    }
}