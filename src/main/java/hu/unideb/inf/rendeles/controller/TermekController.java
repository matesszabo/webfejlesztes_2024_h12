package hu.unideb.inf.rendeles.controller;

import hu.unideb.inf.rendeles.data.entity.TermekEntity;
import hu.unideb.inf.rendeles.data.repository.TermekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TermekController {

    @Autowired
    TermekRepository repository;

    @PostMapping("/savetermek")
    public TermekEntity saveTermek(@RequestBody TermekEntity termek) {
        return repository.save(termek);
    }

    @PutMapping("/updatetermek")
    public TermekEntity updateTermek(@RequestBody TermekEntity termek) {
        if(termek.getId() > 0L){
            return repository.save(termek);
        } else {
            return null;
        }
    }

    @DeleteMapping("/termek")
    public void deleteTermek(@RequestParam Long id){
        repository.deleteById(id);
    }
}
