package com.kisssusha.DAO.models;

import com.kisssusha.DAO.dto.OwnersDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "owners", schema = "public", catalog = "postgres")
public class Owners {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "date", nullable = true)
    private Timestamp date;
    @Basic
    @Column(name = "login", nullable = true, length = -1)
    private String login;
    @Basic
    @Column(name = "password", nullable = true, length = -1)
    private String password;
    @Basic
    @Column(name = "role", nullable = true, length = -1)
    private String role;

    public Owners(OwnersDto own) {
        this.date = own.getDate();
        this.name = own.getName();
        this.login = own.getLogin();
        this.password = own.getPassword();
        this.role = own.getRole();
    }

    public Owners() {
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
        Owners owners = (Owners) o;
        return Objects.equals(id, owners.id) && Objects.equals(name, owners.name) && Objects.equals(date, owners.date) && Objects.equals(login, owners.login) && Objects.equals(password, owners.password) && Objects.equals(role, owners.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, login, password, role);
    }
}
