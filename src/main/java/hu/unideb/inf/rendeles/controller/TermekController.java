package hu.unideb.inf.rendeles.controller;

import hu.unideb.inf.rendeles.data.entity.TermekEntity;
import hu.unideb.inf.rendeles.data.repository.TermekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/termek")
    public List<TermekEntity> findAllTermek(){
        return repository.findAll();
    }

    // /localhost:8080/api/termek/Doboz
    @GetMapping("/termek/{nev}")
    public List<TermekEntity> findAllByNev(@PathVariable String nev){
        List<TermekEntity> valogatott = new ArrayList<TermekEntity>();
        valogatott = repository.findAll()
                .stream()
                .filter(x -> x.getNev().equals(nev))
                .toList();

        return valogatott;
    }

    // /localhost:8080/api/termekbynev?nev=Doboz
    @GetMapping("/termekbynev")
    public List<TermekEntity> findByNev(@RequestParam String nev){
        return repository.findAllByNev(nev);
    }

    @GetMapping("/findfiltered")
    public List<TermekEntity> findFiltered(@RequestParam(required = false) String meret,
                                           @RequestParam(required = false) Float suly,
                                           @RequestParam(required = false) Integer mennyiseg,
                                           @RequestParam(required = false) String nev){

        List<TermekEntity> termekek = repository.findAll();
        return termekek.stream()
                .filter(x -> nev == null || x.getNev().equals(nev))
                .filter(x -> suly == null || x.getSuly().equals(suly))
                .filter(x -> mennyiseg == null || x.getMennyiseg().equals(mennyiseg))
                .filter(x -> meret == null || x.getMeret().equals(meret))
                .toList();
    }


}
