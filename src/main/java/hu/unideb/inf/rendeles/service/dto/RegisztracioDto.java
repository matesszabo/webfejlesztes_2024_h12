package hu.unideb.inf.rendeles.service.dto;

import java.util.Objects;

public class RegisztracioDto {

    private String nev;
    private String email;
    private String password;

    public RegisztracioDto() {
    }

    public RegisztracioDto(String nev, String email, String password) {
        this.nev = nev;
        this.email = email;
        this.password = password;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisztracioDto that = (RegisztracioDto) o;
        return Objects.equals(nev, that.nev) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, email, password);
    }
}
