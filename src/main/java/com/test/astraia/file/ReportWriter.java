package com.test.astraia.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class ReportWriter {
    public Path write(String path, String fileName, String content) throws IOException {
        Path file = Paths.get(path, fileName);
        Files.write(file, Collections.singleton(content), StandardCharsets.UTF_8);
        System.out.println("Created file " + fileName);
        return file;
    }
}
