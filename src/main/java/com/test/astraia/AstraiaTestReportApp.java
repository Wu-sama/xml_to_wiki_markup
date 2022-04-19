package com.test.astraia;

import com.test.astraia.file.ReportListener;
import com.test.astraia.file.ReportWatcher;
import com.test.astraia.service.ReportService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AstraiaTestReportApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String inputFolder = "";

            while (inputFolder.isBlank()){
                System.out.print("Please enter input folder location: ");
                inputFolder = scanner.next();
            }

            String outputFolder = "";
            while (outputFolder.isBlank()){
                System.out.print("Please enter output folder location: ");
                outputFolder = scanner.next();
            }
            ReportService.setOutputFolderPath(outputFolder);

            File folder = new File(inputFolder);
            ReportWatcher watcher = new ReportWatcher(folder);
            watcher.addListener(new ReportListener()).watch();

            System.out.print("For end input exit");
            while(!"exit".equals(scanner.next())){}
            return;
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
