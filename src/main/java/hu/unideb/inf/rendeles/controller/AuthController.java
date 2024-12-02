package hu.unideb.inf.rendeles.controller;

import hu.unideb.inf.rendeles.service.AuthenticationService;
import hu.unideb.inf.rendeles.service.dto.BejelentkezesDto;
import hu.unideb.inf.rendeles.service.dto.RegisztracioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/regisztracio")
    public String regisztracio(@RequestBody RegisztracioDto dto){
        return service.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto dto){
        return service.bejelentkezes(dto);
    }
}
