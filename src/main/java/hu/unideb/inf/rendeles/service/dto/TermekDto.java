package hu.unideb.inf.rendeles.service.dto;

import jakarta.persistence.Column;

import java.util.Objects;

//DTO - Data transfer object
//POJO - Plain old java object
public class TermekDto {

    private Long id;
    private String meret;
    private Float suly;
    private String nev;

    public TermekDto() {
    }

    public TermekDto(Long id, String meret, Float suly, String nev) {
        this.id = id;
        this.meret = meret;
        this.suly = suly;
        this.nev = nev;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeret() {
        return meret;
    }

    public void setMeret(String meret) {
        this.meret = meret;
    }

    public Float getSuly() {
        return suly;
    }

    public void setSuly(Float suly) {
        this.suly = suly;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermekDto termekDto = (TermekDto) o;
        return Objects.equals(id, termekDto.id) && Objects.equals(meret, termekDto.meret) && Objects.equals(suly, termekDto.suly) && Objects.equals(nev, termekDto.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meret, suly, nev);
    }
}
