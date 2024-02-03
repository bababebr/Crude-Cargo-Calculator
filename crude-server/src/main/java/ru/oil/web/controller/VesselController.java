package ru.oil.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.oil.model.dto.VesselDtoShort;
import ru.oil.model.dto.VesselRegRequestDto;
import ru.oil.service.VesselService;

@RestController
@RequestMapping("api/vessel")
@RequiredArgsConstructor
public class VesselController {

  private final VesselService vesselService;

  @PostMapping("/register")
  public VesselDtoShort register(@RequestBody @Valid VesselRegRequestDto regRequest) {
      return vesselService.register(regRequest);

  }


}
