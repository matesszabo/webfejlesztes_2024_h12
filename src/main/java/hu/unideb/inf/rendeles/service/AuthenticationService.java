package hu.unideb.inf.rendeles.service;

import hu.unideb.inf.rendeles.service.dto.BejelentkezesDto;
import hu.unideb.inf.rendeles.service.dto.RegisztracioDto;

public interface AuthenticationService {
    void regisztracio(RegisztracioDto dto);

    void bejelentkezes(BejelentkezesDto dto);
}
