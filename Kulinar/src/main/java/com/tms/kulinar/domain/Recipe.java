package com.tms.kulinar.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
    @SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "taste")
    private int taste;

    @Column(name = "time")
    private int time;

    @Column(name = "amount")
    private int amount;

    @Column(name = "complexity")
    private int complexity;

    @Column(name = "text")
    private String text;

    @Column(name = "feedback_id_fk")
    private int feedback_id_fk;

    @Column(name = "products_id_fk")
    private int products_id_fk;
}
