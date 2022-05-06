package com.kisssusha.DAO.dto;

import com.kisssusha.DAO.models.Friendship;

import java.util.Objects;

public class FriendshipDto {
    private Long id;
    private Long idFriend;
    private Long idCat;

    public FriendshipDto() {
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

    public FriendshipDto(Friendship friends) {
        this.id = friends.getId();
        this.idFriend = friends.getIdFriend();
        this.idCat = friends.getIdCat();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendshipDto that = (FriendshipDto) o;
        return id.equals(that.id) && idFriend.equals(that.idFriend) && idCat.equals(that.idCat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFriend, idCat);
    }


}
