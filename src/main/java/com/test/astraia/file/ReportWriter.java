package com.test.astraia.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class ReportWriter {
    public Path write(String fileName, String content) throws IOException {
        Path file = Paths.get(fileName);
        Files.write(file, Collections.singleton(content), StandardCharsets.UTF_8);
        return file;
    }

    public File createFile(String filename) {
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            return file;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
