package com.test.astraia.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    public File write(String fileName, String content) throws IOException {
        File file = createFile(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
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
