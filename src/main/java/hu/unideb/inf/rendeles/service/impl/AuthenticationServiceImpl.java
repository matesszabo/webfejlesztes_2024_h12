package hu.unideb.inf.rendeles.service.impl;

import hu.unideb.inf.rendeles.data.entity.FelhasznaloEntity;
import hu.unideb.inf.rendeles.data.entity.JogosultsagEntity;
import hu.unideb.inf.rendeles.data.repository.FelhasznaloRepository;
import hu.unideb.inf.rendeles.data.repository.JogosultsagRepository;
import hu.unideb.inf.rendeles.service.AuthenticationService;
import hu.unideb.inf.rendeles.service.JwtService;
import hu.unideb.inf.rendeles.service.dto.BejelentkezesDto;
import hu.unideb.inf.rendeles.service.dto.RegisztracioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    FelhasznaloRepository repo;
    @Autowired
    JogosultsagRepository jogRepo;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtService jwtService;

    @Override
    public String regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity felhasznaloEntity = modelMapper.map(dto, FelhasznaloEntity.class);
        felhasznaloEntity.setJelszo(encoder.encode(felhasznaloEntity.getJelszo()));
        JogosultsagEntity jog = jogRepo.findByNev("FELHASZNALO");
        if (jog != null) {
            felhasznaloEntity.setJogosultsagok(Set.of(jog));
        } else {
            jog = new JogosultsagEntity(null, "FELHASZNALO");
            jog = jogRepo.save(jog);
            felhasznaloEntity.setJogosultsagok(Set.of(jog));
        }

        felhasznaloEntity = repo.save(felhasznaloEntity);

        return jwtService.generateToken(felhasznaloEntity);

    }

    @Override
    public String bejelentkezes(BejelentkezesDto dto) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getJelszo())
        );
        var user = repo.findByEmail(dto.getEmail());
        return jwtService.generateToken(user);
    }
}
