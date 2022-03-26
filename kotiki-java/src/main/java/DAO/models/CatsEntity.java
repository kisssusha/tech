package DAO.models;

import DAO.enums.MyColors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cats", schema = "public", catalog = "postgres")
public class CatsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "birth", nullable = true)
    private Timestamp birth;
    @Basic
    @Column(name = "breed", nullable = true, length = -1)
    private String breed;
    @Basic
    @Column(name = "color", nullable = true, length = -1)
    @Enumerated(EnumType.STRING)
    private MyColors color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatsEntity that = (CatsEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(birth, that.birth) && Objects.equals(breed, that.breed) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birth, breed, color);
    }
}
