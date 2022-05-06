package com.kisssusha.DAO.dto;

import com.kisssusha.DAO.models.Shelter;

import java.util.Objects;

public class ShelterDto {
    private Long id;
    private Long idCat;
    private Long idOwner;
    public ShelterDto(){
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

    public ShelterDto(Shelter shelter){
        this.id = shelter.getId();
        this.idCat = shelter.getIdCat();
        this.idOwner = shelter.getIdOwner();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelterDto that = (ShelterDto) o;
        return Objects.equals(id, that.id) && Objects.equals(idCat, that.idCat)
                && Objects.equals(idOwner, that.idOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCat, idOwner);
    }
}
