package hu.unideb.inf.rendeles.service.impl;

import hu.unideb.inf.rendeles.service.RendelesAllapotService;
import hu.unideb.inf.rendeles.service.dto.RendelesAllapotDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesAllapotServiceImpl implements RendelesAllapotService {
    @Override
    public RendelesAllapotDto getRendelesById(Long id) {
        return null;
    }

    @Override
    public List<RendelesAllapotDto> getAllRendeles() {
        return List.of();
    }
}
