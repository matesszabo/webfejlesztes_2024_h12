package hu.unideb.inf.rendeles.service.impl;

import hu.unideb.inf.rendeles.data.entity.RendelesEntity;
import hu.unideb.inf.rendeles.data.repository.RendelesRepository;
import hu.unideb.inf.rendeles.service.RendelesAllapotService;
import hu.unideb.inf.rendeles.service.dto.RendelesAllapotDto;
import hu.unideb.inf.rendeles.service.mapper.RendelesAllapotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendelesAllapotServiceImpl implements RendelesAllapotService {
    @Autowired
    RendelesAllapotMapper mapper;

    @Autowired
    RendelesRepository repo;

    @Override
    public RendelesAllapotDto getRendelesById(Long id) {
        //return mapper.rendelesEntityToAllapotDto(repo.getReferenceById(id));

        RendelesEntity entity = repo.getReferenceById(id);
        RendelesAllapotDto dto = new RendelesAllapotDto();

        dto = mapper.rendelesEntityToAllapotDto(entity);

        return dto;
    }

    @Override
    public List<RendelesAllapotDto> getAllRendeles() {
        return mapper.rendelesEntityToAllapotList(repo.findAll());
    }
}
