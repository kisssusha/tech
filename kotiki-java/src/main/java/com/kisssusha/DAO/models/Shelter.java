package com.kisssusha.DAO.models;

import com.kisssusha.DAO.dto.ShelterDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shelter", schema = "public", catalog = "postgres")
public class Shelter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "cat_id", nullable = false)
    private Long idCat;
    @Basic
    @Column(name = "owner_id", nullable = false)
    private Long idOwner;

    public Shelter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }

    public Shelter(ShelterDto shelter) {
        this.idCat = shelter.getIdCat();
        this.idOwner = shelter.getIdOwner();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter that = (Shelter) o;
        return Objects.equals(id, that.id) && Objects.equals(idCat, that.idCat)
                && Objects.equals(idOwner, that.idOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCat, idOwner);
    }
}
