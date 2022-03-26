package DAO.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "friendsForCat", schema = "public", catalog = "postgres")
public class FriendsForCatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "idFriend", nullable = false)
    private long idFriend;
    @Basic
    @Column(name = "idCat", nullable = false)
    private long idCat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(long idFriend) {
        this.idFriend = idFriend;
    }

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsForCatEntity that = (FriendsForCatEntity) o;
        return id == that.id && idFriend == that.idFriend && idCat == that.idCat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFriend, idCat);
    }
}
