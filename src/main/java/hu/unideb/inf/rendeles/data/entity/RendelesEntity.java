package hu.unideb.inf.rendeles.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rendeles")
public class RendelesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "rendeles_datuma")
    private Date datum;
    @Column(name = "allapot")
    private String allapot;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "TermekRendelesek",
            joinColumns = { @JoinColumn(name = "rendeles_id")},
            inverseJoinColumns = { @JoinColumn(name = "termek_id")}

    )
    private List<TermekEntity> termekek;

    public RendelesEntity() {
    }

    public RendelesEntity(long id, Date datum, String allapot) {
        this.id = id;
        this.datum = datum;
        this.allapot = allapot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        RendelesEntity that = (RendelesEntity) o;
        return id == that.id && Objects.equals(datum, that.datum) && Objects.equals(allapot, that.allapot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, allapot);
    }
}
