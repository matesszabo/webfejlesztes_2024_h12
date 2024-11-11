package hu.unideb.inf.rendeles.controller;

import hu.unideb.inf.rendeles.service.AuthenticationService;
import hu.unideb.inf.rendeles.service.dto.BejelentkezesDto;
import hu.unideb.inf.rendeles.service.dto.RegisztracioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationService service;

    @PostMapping("/regisztracio")
    public void regisztracio(@RequestBody RegisztracioDto dto){
        service.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public void bejelentkezes(@RequestBody BejelentkezesDto dto){
        service.bejelentkezes(dto);
    }
}
