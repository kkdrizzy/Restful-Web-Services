package com.example.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 2, message = "Name Should have atleast 2 Characters")
    private String name;
    @Past(message = "Birthdate should always be in the past")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User() {
    }

    public User(Long id, String name, LocalDate birthdate, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.posts = posts;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getBirthdate(), user.getBirthdate()) && Objects.equals(getPosts(), user.getPosts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthdate(), getPosts());
    }
}
