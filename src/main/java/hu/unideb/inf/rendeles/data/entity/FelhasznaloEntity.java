package hu.unideb.inf.rendeles.data.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Felhasznalo")
public class FelhasznaloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nev")
    private String nev;
    @Column(name = "email")
    private String email;
    @Column(name = "jelszo")
    private String jelszo;

    @ManyToMany
    private Set<JogosultsagEntity> jogosultsagok;

    public FelhasznaloEntity() {
    }

    public FelhasznaloEntity(Long id, String nev, String email, String jelszo) {
        this.id = id;
        this.nev = nev;
        this.email = email;
        this.jelszo = jelszo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public Set<JogosultsagEntity> getJogosultsagok() {
        return jogosultsagok;
    }

    public void setJogosultsagok(Set<JogosultsagEntity> jogosultsagok) {
        this.jogosultsagok = jogosultsagok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloEntity that = (FelhasznaloEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nev, that.nev) && Objects.equals(email, that.email) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, email, jelszo);
    }
}