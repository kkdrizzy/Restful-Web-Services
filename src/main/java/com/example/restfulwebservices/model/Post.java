package com.example.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 2, message = "Post Should have atleast 2 Characters")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
    }

    public Post(Long id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(getId(), post.getId()) && Objects.equals(getDescription(), post.getDescription()) && Objects.equals(getUser(), post.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getUser());
    }
}
