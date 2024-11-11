package hu.unideb.inf.rendeles.service.dto;

import java.util.Objects;

public class BejelentkezesDto {

    String email;
    String jelszo;

    public BejelentkezesDto() {
    }

    public BejelentkezesDto(String email, String jelszo) {
        this.email = email;
        this.jelszo = jelszo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BejelentkezesDto that = (BejelentkezesDto) o;
        return Objects.equals(email, that.email) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, jelszo);
    }
}
