package com.example.training.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "school", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Student> students;
}