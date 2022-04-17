package com.test.astraia.file;

import com.test.astraia.model.xsd.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.File;

class FileReaderTest {
    private final ReportReader reportReader =  new ReportReader();

    @Test
    public void readFile() throws JAXBException {
        String filePath = "BuildReportTask/examples/example1/example1.xml";
        File file = new File(filePath);
        Report report = reportReader.readFile(file);

        Assertions.assertNotNull(report);
    }

    @Test
    public void readFile2() throws JAXBException {
        String filePath = "BuildReportTask/examples/example2/example2.xml";
        File file = new File(filePath);
        Report report = reportReader.readFile(file);

        Assertions.assertNotNull(report);
    }
}