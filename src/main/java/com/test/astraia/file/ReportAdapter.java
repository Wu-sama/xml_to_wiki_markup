package com.test.astraia.file;

import com.test.astraia.service.ReportService;

import java.io.File;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportAdapter implements FileListener {
    private final Pattern pattern = Pattern.compile("^.*\\.(xml|XML)$");
    private final ReportService reportService;

    public ReportAdapter(){
        this.reportService = new ReportService();
    }

    @Override
    public void onCreated(FileEvent event) {
        File file = event.getFile();
        onCreated(file);
    }

    private void onCreated(File file) {
        Matcher matcher = pattern.matcher(file.getName());
        if (matcher.matches()) {
            reportService.formatReport(file);
        } else {
            System.out.println("A file " + file + " is not xml");
        }
    }

    @Override
    public void onCreated(Path file) {
        onCreated(file.toFile());
    }
}
