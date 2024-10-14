package hu.unideb.inf.rendeles.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "hely")
public class HelyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "sor", nullable = false)
    private int sor;
    @Column(name = "polc", nullable = false)
    private int polc;

    public HelyEntity() {
    }

    public HelyEntity(long id, int sor, int polc) {
        this.id = id;
        this.sor = sor;
        this.polc = polc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSor() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }

    public int getPolc() {
        return polc;
    }

    public void setPolc(int polc) {
        this.polc = polc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelyEntity that = (HelyEntity) o;
        return id == that.id && sor == that.sor && polc == that.polc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sor, polc);
    }
}




