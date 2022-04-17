package com.test.astraia.file;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ReportWriterTest {
    private final ReportWriter writer = new ReportWriter();

    @Test
    void write() throws IOException {
        String example1 = getContent();

        String path = "src/test/resources/example1.wiki";
        Files.deleteIfExists(Path.of(path));
        Path file = writer.write(path,example1);

        String result= Files.readString(file);

        assertEquals(example1+"\n", result);
        Files.deleteIfExists(file);
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
                "'''Failed:''' None";
    }
}