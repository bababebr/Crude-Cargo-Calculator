package ru.oil.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.oil.model.dto.VesselDtoShort;
import ru.oil.model.dto.VesselRegRequestDto;
import ru.oil.repository.VesselRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class VesselService {

  private final VesselRepository vesselRepository;

  public VesselDtoShort register(VesselRegRequestDto regRequest) {

  }
}
