package com.test.astraia;

import com.test.astraia.file.ReportAdapter;
import com.test.astraia.file.ReportWatcher;
import com.test.astraia.service.ReportService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class AstraiaTestReportApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputFolder = getFolderPath(scanner, "input");
            String outputFolder = getFolderPath(scanner, "output");

            ReportService.setOutputFolderPath(outputFolder);
            ReportAdapter reportAdapter = new ReportAdapter();

            File folder = new File(inputFolder);
            readAndFormatPreviouslyCreatedFiles(folder, reportAdapter);
            configureReportCreationWatcher(folder, reportAdapter);

            System.out.print("For end input exit");
            while (!"exit".equals(scanner.next())) {}
        }
    }

    private static void readAndFormatPreviouslyCreatedFiles(File folder, ReportAdapter reportAdapter) {
        try (Stream<Path> paths = Files.walk(folder.toPath())) {
            paths
                    .sequential()
                    .filter(Files::isRegularFile)
                    .forEach(reportAdapter::onCreated);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void configureReportCreationWatcher(File folder, ReportAdapter reportAdapter) {
        ReportWatcher watcher = new ReportWatcher(folder);
        watcher.addListener(reportAdapter).watch();
    }

    private static String getFolderPath(Scanner scanner, String folderType) {
        String folder = "";

        while (folder.isBlank()){
            System.out.print("Please enter "+folderType+" folder location: ");
            folder = scanner.next();
        }
        return folder;
    }
}
