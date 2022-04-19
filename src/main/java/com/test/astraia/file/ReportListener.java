package com.test.astraia.file;

import com.test.astraia.service.ReportService;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportListener implements FileListener {
    private final Pattern pattern = Pattern.compile("^.*\\.(xml|XML)$");
    private ReportService reportService;

    public ReportListener(){
        this.reportService = new ReportService();
    }
    @Override
    public void onCreated(FileEvent event) {
        File file = event.getFile();
        Matcher matcher = pattern.matcher(file.getName());
        if (matcher.matches()) {
            reportService.formatReport(file);
        } else {
            System.out.println("A file " + event.getFile() + " is not xml");
        }
    }
}
