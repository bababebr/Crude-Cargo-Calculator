package com.example.oct.ullageReport;

import com.example.oct.cargo.Cargo;
import com.example.oct.cargo.CargoRepository;
import com.example.oct.enums.Tables;
import com.example.oct.ullage.UllageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UllageReportService implements IUllageReportService {

    @Autowired
    private UllageRepository ullageRepository;
    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<UllageReport> createReport(Map<String, Cargo> tanksAndCargosMap, Tables table) {
        for()
    }

}
