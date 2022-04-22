package com.kisssusha.DAO.models;

import com.kisssusha.DAO.dto.FriendshipDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "friend_for_cat", schema = "public", catalog = "postgres")
public class Friendship {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "first_cat_id", nullable = false)
    private Long idFriend;
    @Basic
    @Column(name = "second_cat_id", nullable = false)
    private Long idCat;

    public Friendship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(Long idFriend) {
        this.idFriend = idFriend;
    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public Friendship(FriendshipDto friends) {
        this.idCat = friends.getIdCat();
        this.idFriend = friends.getIdFriend();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return Objects.equals(id, that.id) && Objects.equals(idFriend, that.idFriend)
                && Objects.equals(idCat, that.idCat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFriend, idCat);
    }
}
