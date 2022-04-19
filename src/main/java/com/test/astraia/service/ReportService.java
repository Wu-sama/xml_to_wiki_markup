package com.test.astraia.service;

import com.test.astraia.file.ReportReader;
import com.test.astraia.file.ReportWriter;
import com.test.astraia.model.xsd.Report;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class ReportService {
    private final WikiReportService watchService = new WikiReportService();
    private final ReportReader reader = new ReportReader();
    private final ReportWriter writer = new ReportWriter();
    private static String outputFolderPath;

    public static void setOutputFolderPath(String outputFolder) {
        outputFolderPath = outputFolder;
    }

    public void formatReport(File file){
        try {
            Report report = reader.readFile(file);
            String wikiReport = watchService.toWikiFormat(report);
            writer.write(outputFolderPath, file.getName().replaceAll(".xml|.XML", ".wiki"), wikiReport);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
