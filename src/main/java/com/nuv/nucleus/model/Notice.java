package com.nuv.nucleus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notices")
public class Notice {

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
    private String content;

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Column(length = 2000)
    private LocalDateTime postedAt;

    public LocalDateTime getPostedAt() { return postedAt; }
    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posted_by")
    private User postedBy;

    // FIX IS HERE: Changed 'Postedby' to 'PostedBy'
    public User getPostedBy() { return postedBy; }
    public void setPostedBy(User postedBy) { this.postedBy = postedBy; }
}