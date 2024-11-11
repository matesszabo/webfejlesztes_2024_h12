package hu.unideb.inf.rendeles.service.impl;

import hu.unideb.inf.rendeles.data.entity.FelhasznaloEntity;
import hu.unideb.inf.rendeles.data.entity.JogosultsagEntity;
import hu.unideb.inf.rendeles.data.repository.FelhasznaloRepository;
import hu.unideb.inf.rendeles.service.AuthenticationService;
import hu.unideb.inf.rendeles.service.dto.RegisztracioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    FelhasznaloRepository repo;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity felhasznaloEntity = modelMapper.map(dto, FelhasznaloEntity.class);
        felhasznaloEntity.setJelszo(encoder.encode(felhasznaloEntity.getJelszo()));
        felhasznaloEntity.setJogosultsagok(Set.of(new JogosultsagEntity(1L,"FELHASZNALO")));

        repo.save(felhasznaloEntity);

    }
}
