package com.test.astraia.service;

import com.test.astraia.file.ReportReader;
import com.test.astraia.file.ReportWriter;
import com.test.astraia.model.xsd.Report;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class ReportService {
    private static WikiReportService watchService = new WikiReportService();
    private static ReportReader reader = new ReportReader();
    private static ReportWriter writer = new ReportWriter();
    private static String outputFolderPath;

    public static void setOutputFolderPath(String outputFolderPath) {
        outputFolderPath = outputFolderPath;
    }

    public void formatReport(File file){
        try {
            Report report = reader.readFile(file);
            String wikiReport = watchService.toWikiFormat(report);
            writer.write(outputFolderPath, wikiReport);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
