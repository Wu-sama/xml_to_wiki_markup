package com.test.astraia;

import com.test.astraia.file.ReportListener;
import com.test.astraia.file.ReportWatcher;
import com.test.astraia.service.ReportService;

import java.io.File;
import java.util.Scanner;

public class AstraiaTestReportApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputFolder = getFolderPath(scanner, "input");
            String outputFolder = getFolderPath(scanner, "output");

            ReportService.setOutputFolderPath(outputFolder);

            File folder = new File(inputFolder);
            ReportWatcher watcher = new ReportWatcher(folder);
            watcher.addListener(new ReportListener()).watch();

            System.out.print("For end input exit");
            while (!"exit".equals(scanner.next())) {
            }
        }
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
