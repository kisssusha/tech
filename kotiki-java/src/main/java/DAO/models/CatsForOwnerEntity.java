package DAO.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "catsForOwner", schema = "public", catalog = "postgres")
public class CatsForOwnerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "idCat", nullable = false)
    private long idCat;
    @Basic
    @Column(name = "idOwner", nullable = false)
    private long idOwner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }

    public long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatsForOwnerEntity that = (CatsForOwnerEntity) o;
        return id == that.id && idCat == that.idCat && idOwner == that.idOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCat, idOwner);
    }
}
