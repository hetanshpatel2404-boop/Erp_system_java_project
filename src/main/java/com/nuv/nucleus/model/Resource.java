package com.nuv.nucleus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(length = 2000)
    private String title;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Column(length = 2000)
    private String description;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Column(length = 2000)
    private String url;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @Column(length = 2000)
    private String category;

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;

    // FIX IS HERE: Changed 'Uploadedby' to 'UploadedBy'
    public User getUploadedBy() { return uploadedBy; }
    public void setUploadedBy(User uploadedBy) { this.uploadedBy = uploadedBy; }
}