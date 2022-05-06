package com.kisssusha.DAO.dto;

import com.kisssusha.DAO.models.Owners;

import java.sql.Timestamp;
import java.util.Objects;

public class OwnersDto {
    private Long id;
    private String name;
    private Timestamp date;
    private String login;
    private String password;
    private String role;

    public OwnersDto(Owners owners){
        this.id = owners.getId();
        this.date = owners.getDate();
        this.name = owners.getName();
        this.login = owners.getLogin();
        this.password = owners.getPassword();
        this.role = owners.getRole();
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnersDto ownersDto = (OwnersDto) o;
        return Objects.equals(id, ownersDto.id) && Objects.equals(name, ownersDto.name) && Objects.equals(date, ownersDto.date) && Objects.equals(login, ownersDto.login) && Objects.equals(password, ownersDto.password) && Objects.equals(role, ownersDto.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, login, password, role);
    }
}
