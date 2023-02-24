package com.example.java_spring_hw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "tasks")
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private Date createdAt;

    private boolean isStarted;

    private String dsc;
}
