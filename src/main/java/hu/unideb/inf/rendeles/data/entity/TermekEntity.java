package hu.unideb.inf.rendeles.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "termek")
public class TermekEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "meret")
    private String meret;
    @Column(name = "suly")
    private Float suly;
    @Column(name = "mennyiseg")
    private Integer mennyiseg;
    @Column(name = "nev")
    private String nev;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hely_id", referencedColumnName = "id")
    private HelyEntity hely;

    public TermekEntity() {
    }

    public TermekEntity(long id, String meret, Float suly, Integer mennyiseg, String nev) {
        this.id = id;
        this.meret = meret;
        this.suly = suly;
        this.mennyiseg = mennyiseg;
        this.nev = nev;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Integer getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Integer mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public HelyEntity getHely() {
        return hely;
    }

    public void setHely(HelyEntity hely) {
        this.hely = hely;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermekEntity that = (TermekEntity) o;
        return id == that.id && Objects.equals(meret, that.meret) && Objects.equals(suly, that.suly) && Objects.equals(mennyiseg, that.mennyiseg) && Objects.equals(nev, that.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meret, suly, mennyiseg, nev);
    }
}
