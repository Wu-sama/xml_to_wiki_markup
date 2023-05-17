package com.test.wiki.markup.service;

import com.test.wiki.markup.model.ReportModel;
import com.test.wiki.markup.model.xsd.Report;

public class WikiReportService {
    private final ReportMapper reportMapper =  new ReportMapper();

    public String toWikiFormat(Report report){
        if(report == null || report.getContent().isEmpty()){
            return "";
        }
        ReportModel model = reportMapper.mapToModel(report);
        return model.toString();
    }
}
