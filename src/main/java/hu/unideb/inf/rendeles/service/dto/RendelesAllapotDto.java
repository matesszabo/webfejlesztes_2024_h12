package hu.unideb.inf.rendeles.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;

public class RendelesAllapotDto {

    private Long id;
    private Date datum;
    private String allapot;

    public RendelesAllapotDto() {
    }

    public RendelesAllapotDto(Long id, Date datum, String allapot) {
        this.id = id;
        this.datum = datum;
        this.allapot = allapot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getAllapot() {
        return allapot;
    }

    public void setAllapot(String allapot) {
        this.allapot = allapot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendelesAllapotDto that = (RendelesAllapotDto) o;
        return Objects.equals(id, that.id) && Objects.equals(datum, that.datum) && Objects.equals(allapot, that.allapot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, allapot);
    }
}
