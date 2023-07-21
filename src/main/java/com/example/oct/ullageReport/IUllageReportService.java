package com.example.oct.ullageReport;

import com.example.oct.cargo.Cargo;
import com.example.oct.enums.Tables;

import java.util.List;
import java.util.Map;

public interface IUllageReportService {

    List<UllageReport> createReport(Map<String, Cargo> tanksAndCargosMap, Tables tables);

}
