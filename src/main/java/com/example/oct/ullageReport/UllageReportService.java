package com.example.oct.ullageReport;

import com.example.oct.cargo.Cargo;
import com.example.oct.cargo.CargoMapper;
import com.example.oct.cargo.CargoService;
import com.example.oct.cargo.dto.CargoDto;
import com.example.oct.enums.Tables;
import com.example.oct.ullage.UllageService;
import com.example.oct.ullage.dto.UllageDto;
import com.example.oct.ullage.dto.UllageDtoShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UllageReportService implements IUllageReportService {

    @Autowired
    private UllageService ullageService;
    @Autowired
    private CargoService cargoService;

    @Override
    public List<UllageReport> createReport(Map<String, Cargo> tanksAndCargosMap, double ullage, double trim, Tables table) {
        List<UllageReport> ullageReport = new ArrayList<>();
        for (var entry : tanksAndCargosMap.entrySet()) {
            UllageReport reportEntry = new UllageReport();

            UllageDto dto = ullageService.getByUllageAndTank(ullage, entry.getKey());
            UllageDtoShort ullageDtoShort;
            if (table.equals(Tables.Table6A) || table.equals(Tables.Table6B)) {
                ullageDtoShort = ullageService.getUllage(dto, trim, entry.getValue().getApi(),
                        entry.getValue().getTemp_f(), table);
            } else {
                ullageDtoShort = ullageService.getUllage(dto, trim, entry.getValue().getDensity(),
                        entry.getValue().getTemp_c(), table);
            }
            reportEntry.setUllage(ullageDtoShort);
            reportEntry.setTable(table.name());
            reportEntry.setCargo(CargoMapper.cargoToDto(entry.getValue()));
            reportEntry.setTankName(entry.getKey());
        }
        return ullageReport;
    }

    public UllageReport getOneTank(String tank, String cargoName, double ullage, double trim, Tables table) {
        UllageDtoShort ullageDtoShort;
        UllageReport tankReport = new UllageReport();
        UllageDto dto = ullageService.getByUllageAndTank(ullage, tank);
        CargoDto cargo = cargoService.findByName(cargoName);
        if (table.equals(Tables.Table6A) || table.equals(Tables.Table6B)) {
            ullageDtoShort = ullageService.getUllage(dto, trim, cargo.getApi(),
                    cargo.getTemp_f(), table);
        } else {
            ullageDtoShort = ullageService.getUllage(dto, trim, cargo.getDensity(),
                    cargo.getTemp_c(), table);
        }
        tankReport.setUllage(ullageDtoShort);
        tankReport.setTable(table.name());
        tankReport.setCargo(cargo);
        tankReport.setTankName(tank);
        return tankReport;
    }
}
