package com.app.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="user-groups")
public class Group extends BaseModel{

    private String name;
    @ManyToMany
    private List<User> users;
    @ManyToOne
    private User admin;
    @OneToMany( mappedBy = "group")
    private List<Expense> expenses;
}
