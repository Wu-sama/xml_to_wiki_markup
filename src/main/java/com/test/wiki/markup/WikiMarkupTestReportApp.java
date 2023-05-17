package com.test.wiki.markup;

import com.test.wiki.markup.file.ReportAdapter;
import com.test.wiki.markup.file.ReportWatcher;
import com.test.wiki.markup.service.ReportService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class WikiMarkupTestReportApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputFolder = getFolderPath(scanner, "input");
            String outputFolder = getFolderPath(scanner, "output");

            ReportService.setOutputFolderPath(outputFolder);
            ReportAdapter reportAdapter = new ReportAdapter();

            File folder = new File(inputFolder);
            readAndFormatPreviouslyCreatedFiles(folder, reportAdapter);
            configureReportCreationWatcher(folder, reportAdapter);

            System.out.print("For end input exit: ");
            while (!"exit".equals(scanner.next())) {
            }
        }
    }

    private static void readAndFormatPreviouslyCreatedFiles(File folder, ReportAdapter reportAdapter) {
        try (Stream<Path> paths = Files.walk(folder.toPath())) {
            paths
                    .sequential()
                    .filter(Files::isRegularFile)
                    .forEach(reportAdapter::onCreated);
        } catch (IOException e) {
            System.out.println("Exception during an attempt to read all files from a folder " + folder.getAbsolutePath() + " : " + e.getMessage());
        }
    }

    private static void configureReportCreationWatcher(File folder, ReportAdapter reportAdapter) {
        ReportWatcher watcher = new ReportWatcher(folder);
        watcher.addListener(reportAdapter).watch();
    }

    private static String getFolderPath(Scanner scanner, String folderType) {
        String folder = "";
        boolean isValidPath = false;

        while (folder.isBlank() || !isValidPath) {
            System.out.print("Please enter " + folderType + " folder location: ");
            if(scanner.hasNext()) {
                folder = scanner.next();
                isValidPath = isValidPath(folder);
            }
        }
        return folder;
    }

    private static boolean isValidPath(String folder) {
        if (!folder.isBlank()) {
            try {
                Path path = Paths.get(folder);
                if (Files.isDirectory(path)) {
                    return true;
                } else {
                    System.out.println("Entered path is not a folder.");
                }
            } catch (Exception e) {
                System.out.println("Wrong folder path: " + e.getMessage());
            }
        }
        return false;
    }
}
