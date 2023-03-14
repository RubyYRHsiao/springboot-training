package com.example.training.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @NotBlank
    @Size(max = 20, message = "Name can not be more than 20 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Builder.Default
    @Column(name = "is_complete")
    private Boolean isComplete = false;

    @OneToOne(mappedBy = "task", fetch = FetchType.LAZY)
    private Pay pay;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_task",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<Student> assigned;
}