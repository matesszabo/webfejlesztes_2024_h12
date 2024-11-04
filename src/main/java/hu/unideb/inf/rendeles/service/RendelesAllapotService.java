package hu.unideb.inf.rendeles.service;

import hu.unideb.inf.rendeles.service.dto.RendelesAllapotDto;

import java.util.List;

public interface RendelesAllapotService {

    RendelesAllapotDto getRendelesById(Long id);
    List<RendelesAllapotDto> getAllRendeles();

}
