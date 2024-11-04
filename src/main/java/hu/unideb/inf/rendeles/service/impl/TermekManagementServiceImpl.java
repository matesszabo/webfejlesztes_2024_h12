package hu.unideb.inf.rendeles.service.impl;

import hu.unideb.inf.rendeles.data.entity.TermekEntity;
import hu.unideb.inf.rendeles.data.repository.TermekRepository;
import hu.unideb.inf.rendeles.service.TermekManagementService;
import hu.unideb.inf.rendeles.service.dto.TermekDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TermekManagementServiceImpl implements TermekManagementService {

    @Autowired
    TermekRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public TermekDto save(TermekDto termekDto) {
        //ModelMapper modelMapper = new ModelMapper();

        TermekEntity entity = new TermekEntity();

        entity.setNev(termekDto.getNev());
        entity.setHely(null);
        entity.setSuly(termekDto.getSuly());
        entity.setMeret(termekDto.getMeret());
        entity.setMennyiseg(null);

        entity = repo.save(entity);

        TermekDto dto = new TermekDto(entity.getId(),
                entity.getMeret(),
                entity.getSuly(),
                entity.getNev());

        return dto;
    }

    @Override
    public TermekDto findById(Long id) {
        //return mapper.map(repo.getReferenceById(id), TermekDto.class);

        TermekEntity entity = repo.getReferenceById(id);
        TermekDto dto = new TermekDto();

        dto = mapper.map(entity, TermekDto.class);

        return dto;
    }

    @Override
    public List<TermekDto> findAll() {
        List<TermekEntity> entities = repo.findAll();
        List<TermekDto> dtos = new ArrayList<>();

        dtos = mapper.map(entities, new TypeToken<List<TermekDto>>(){}.getType());

        return dtos;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
