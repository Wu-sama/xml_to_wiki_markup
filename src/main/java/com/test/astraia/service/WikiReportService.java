package com.test.astraia.service;

import com.test.astraia.model.ReportModel;
import com.test.astraia.model.xsd.Report;

public class WikiReportService {
    private ReportMapper reportMapper =  new ReportMapper();

    public String toWikiFormat(Report report){
        ReportModel model = reportMapper.mapToModel(report);
        return model.toString();
    }
}
