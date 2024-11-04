package hu.unideb.inf.rendeles.service;

import hu.unideb.inf.rendeles.service.dto.TermekDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TermekManagementService {

    TermekDto save(TermekDto termekDto);

    TermekDto findById(Long id);

    List<TermekDto> findAll();

    void delete(Long id);

    List<TermekDto> findAllByNevKod(String nev);

    List<TermekDto> findAllByNevDb(String nev);

    List<TermekDto> findAllByAny(String meret,
                                 Float suly,
                                 Integer mennyiseg,
                                 String nev);

}
