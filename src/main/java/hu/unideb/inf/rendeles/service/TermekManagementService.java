package hu.unideb.inf.rendeles.service;

import hu.unideb.inf.rendeles.service.dto.TermekDto;

import java.util.List;

public interface TermekManagementService {

    TermekDto save(TermekDto termekDto);

    TermekDto findById(Long id);

    List<TermekDto> findAll();

    void delete(Long id);

}
