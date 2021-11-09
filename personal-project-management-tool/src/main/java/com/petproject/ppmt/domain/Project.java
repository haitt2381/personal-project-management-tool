package com.petproject.ppmt.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = new Date();
    }
}
