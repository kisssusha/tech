package com.kisssusha.DAO.dto;

import com.kisssusha.DAO.enums.MyColors;
import com.kisssusha.DAO.models.Cats;

import java.sql.Timestamp;
import java.util.Objects;

public class CatsDto {
    private Long id;
    private String name;
    private Timestamp birth;
    private String breed;
    private MyColors color;

    public CatsDto() {
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

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public MyColors getColor() {
        return color;
    }

    public void setColor(MyColors color) {
        this.color = color;
    }

    public CatsDto(Cats cat) {
        this.id = cat.getId();
        this.birth = cat.getBirth();
        this.breed = cat.getBreed();
        this.name = cat.getName();
        this.color = cat.getColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatsDto catDTO = (CatsDto) o;
        return Objects.equals(id, catDTO.id) && color == catDTO.color && Objects.equals(name, catDTO.name)
                && Objects.equals(breed, catDTO.breed)
                && Objects.equals(birth, catDTO.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, name, breed, birth);
    }
}

