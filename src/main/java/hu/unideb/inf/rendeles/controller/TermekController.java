package hu.unideb.inf.rendeles.controller;

import hu.unideb.inf.rendeles.data.repository.TermekRepository;
import hu.unideb.inf.rendeles.service.TermekManagementService;
import hu.unideb.inf.rendeles.service.dto.TermekDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api")
public class TermekController {

    @Autowired
    TermekManagementService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/savetermek")
    public TermekDto saveTermek(@RequestBody TermekDto termek) {
        return service.save(termek);
    }

    @PutMapping("/updatetermek")
    public TermekDto updateTermek(@RequestBody TermekDto termek) {
        if(termek.getId() > 0L){
            return service.save(termek);
        } else {
            return null;
        }
    }

    @DeleteMapping("/termek")
    public void deleteTermek(@RequestParam Long id){
        service.delete(id);
    }

    @GetMapping("/termek")
    public List<TermekDto> findAllTermek(){
        return service.findAll();
    }

    // /localhost:8080/api/termek/Doboz
    @GetMapping("/termek/{nev}")
    public List<TermekDto> findAllByNev(@PathVariable String nev){
        return service.findAllByNevDb(nev);
    }

    // /localhost:8080/api/termekbynev?nev=Doboz
    @GetMapping("/termekbynev")
    public List<TermekDto> findByNev(@RequestParam String nev){
        return service.findAllByNevKod(nev);
    }

    @GetMapping("/findfiltered")
    public List<TermekDto> findFiltered(@RequestParam(required = false) String meret,
                                           @RequestParam(required = false) Float suly,
                                           @RequestParam(required = false) Integer mennyiseg,
                                           @RequestParam(required = false) String nev){
        return service.findAllByAny(meret,suly,mennyiseg,nev);

    }


}
