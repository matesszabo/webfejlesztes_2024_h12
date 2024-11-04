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

    @Override
    public List<TermekDto> findAllByNevKod(String nev) {
        List<TermekEntity> valogatott = new ArrayList<TermekEntity>();
        valogatott = repo.findAll()
                .stream()
                .filter(x -> x.getNev().equals(nev))
                .toList();

        return mapper.map(valogatott, new TypeToken<List<TermekDto>>(){}.getType());
    }

    @Override
    public List<TermekDto> findAllByNevDb(String nev) {
        return mapper.map(repo.findAllByNev(nev), new TypeToken<List<TermekDto>>(){}.getType());
    }

    @Override
    public List<TermekDto> findAllByAny(String meret, Float suly, Integer mennyiseg, String nev) {
        List<TermekEntity> termekek = repo.findAll();
        termekek = termekek.stream()
                .filter(x -> nev == null || x.getNev().equals(nev))
                .filter(x -> suly == null || x.getSuly().equals(suly))
                .filter(x -> mennyiseg == null || x.getMennyiseg().equals(mennyiseg))
                .filter(x -> meret == null || x.getMeret().equals(meret))
                .toList();

        return mapper.map(termekek, new TypeToken<List<TermekDto>>(){}.getType());
    }
}
