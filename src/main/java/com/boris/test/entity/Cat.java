package com.boris.test.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "cats")
@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String owner;
    private int age;

    public Cat(String name, String owner, int age) {
        this.name = name;
        this.owner = owner;
        this.age = age;
    }
}
