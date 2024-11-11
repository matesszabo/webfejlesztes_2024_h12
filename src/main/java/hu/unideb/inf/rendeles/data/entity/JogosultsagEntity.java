package hu.unideb.inf.rendeles.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Jogosultsag")
public class JogosultsagEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nev")
    private String nev;

    public JogosultsagEntity() {
    }

    public JogosultsagEntity(Long id, String nev) {
        this.id = id;
        this.nev = nev;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogosultsagEntity that = (JogosultsagEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nev, that.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev);
    }
}
