package com.tms.kulinar.domain;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Data
@Entity
@Table(name= "users")
public class Users {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_K_id_seq")
   @SequenceGenerator(name = "users_K_id_seq", sequenceName = "users_K_id_seq", allocationSize = 1)
    int id;
 @Column(name="recipe_id_fk")
    int recipe_id_fk;
    @Column(name="first_name")
    String first_name;

    @Column(name="last_name")
    String last_name;
    @Column(name="email")

    String email;
    @Column(name="level")

    int level;

    @Column(name="phone")
    int phone;

    private static final Logger log = LoggerFactory.getLogger(Users.class);

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", recipe_id_fk=" + recipe_id_fk +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                ", phone=" + phone +
                '}';
    }
}
