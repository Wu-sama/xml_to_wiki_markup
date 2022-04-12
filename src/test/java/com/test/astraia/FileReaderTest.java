package com.test.astraia;

import com.test.astraia.file.FileReader;
import com.test.astraia.model.xsd.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

class FileReaderTest {
    private FileReader fileReader =  new FileReader();

    @Test
    public void readFile() throws JAXBException {
        String filePath = "BuildReportTask/examples/example1/example1.xml";

        Report report = fileReader.readFile(filePath);

        Assertions.assertNotNull(report);
    }

    @Test
    public void readFile2() throws JAXBException {
        String filePath = "BuildReportTask/examples/example2/example2.xml";

        Report report = fileReader.readFile(filePath);

        Assertions.assertNotNull(report);
    }
}