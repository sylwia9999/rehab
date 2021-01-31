package com.rehabilitation.Object;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    private String name;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public Role() {
    }
    public Role(int roleId) {
        this.roleId = roleId;
    }

    public Role(int roleId, String name, List<User> users) {
        this.roleId = roleId;
        this.name = name;
        this.users = users;
    }

    public int getRole_id() {
        return roleId;
    }

    public void setRole_id(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
