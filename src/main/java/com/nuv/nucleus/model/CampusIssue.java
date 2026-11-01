package com.nuv.nucleus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "campus_issues")
public class CampusIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String location;

    @Column(length = 2000)
    private String category;

    @Column(length = 2000)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reported_by")
    private User user;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }


}
