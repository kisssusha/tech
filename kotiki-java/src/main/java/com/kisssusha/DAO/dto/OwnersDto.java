package com.kisssusha.DAO.dto;

import com.kisssusha.DAO.models.Owners;

import java.sql.Timestamp;
import java.util.Objects;

public class OwnersDto {
    private Long id;
    private String name;
    private Timestamp date;

    public OwnersDto(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public OwnersDto(Owners owners){
        this.id = owners.getId();
        this.date = owners.getDate();
        this.name = owners.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnersDto ownersDto = (OwnersDto) o;
        return id.equals(ownersDto.id) && name.equals(ownersDto.name) && date.equals(ownersDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date);
    }
}
