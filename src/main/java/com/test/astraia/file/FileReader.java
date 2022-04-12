package com.test.astraia.file;

import com.test.astraia.model.xsd.Report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class FileReader {
    public Report readFile(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Report) jaxbUnmarshaller.unmarshal(new File(path));
    }
}
