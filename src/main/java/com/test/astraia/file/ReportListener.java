package com.test.astraia.file;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportListener implements FileListener {
    private final Pattern pattern = Pattern.compile("^.*\\.(xml|XML)$");

    @Override
    public void onCreated(FileEvent event) {
        File file = event.getFile();
        Matcher matcher = pattern.matcher("My_File_Name.txt");
        if (matcher.matches()) {

        } else {
            System.out.println("A file " + event.getFile() + " is not xml");
        }
    }
}
