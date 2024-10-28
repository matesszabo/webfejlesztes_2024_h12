package hu.unideb.inf.rendeles.controller;

import hu.unideb.inf.rendeles.data.entity.TermekEntity;
import hu.unideb.inf.rendeles.data.repository.TermekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TermekController {

    @Autowired
    TermekRepository repository;

    @PostMapping("/savetermek")
    public TermekEntity saveTermek(@RequestBody TermekEntity termek) {
        return repository.save(termek);
    }
}
