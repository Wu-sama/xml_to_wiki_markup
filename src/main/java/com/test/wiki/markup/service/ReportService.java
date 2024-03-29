package com.test.wiki.markup.service;

import com.test.wiki.markup.file.ReportReader;
import com.test.wiki.markup.file.ReportWriter;
import com.test.wiki.markup.model.xsd.Report;
import jakarta.xml.bind.JAXBException;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ReportService {
    private final WikiReportService watchService = new WikiReportService();
    private final ReportReader reader = new ReportReader();
    private final ReportWriter writer = new ReportWriter();
    private static String outputFolderPath;

    public static void setOutputFolderPath(String outputFolder) {
        outputFolderPath = outputFolder;
    }

    public Path formatReport(File file){
        try {
            Report report = reader.readFile(file);
            String wikiReport = watchService.toWikiFormat(report);
            return writer.write(outputFolderPath, file.getName().replaceAll(".xml|.XML", ".wiki"), wikiReport);
        } catch (JAXBException | IOException | XMLStreamException e) {
            System.out.println("An attempt to format report is failed. Cause: " + e.getMessage());
        }
        return null;
    }
}
