package com.exercise.api_rest.tsg.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "posts")
public class Post {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonProperty("posted_by_user")
    public Integer idFromUser() {
        return user.getId();
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }
}