package com.nuv.nucleus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String achievementDate;

    @Column(length = 2000)
    private String proofUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAchievementDate() { return achievementDate; }
    public void setAchievementDate(String achievementDate) { this.achievementDate = achievementDate; }

    public String getProofUrl() { return proofUrl; }
    public void setProofUrl(String proofUrl) { this.proofUrl = proofUrl; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }


}
