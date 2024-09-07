package com.ubs.hackathon.questboard.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "ubs_user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UbsUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String gpn;
    private String name;
    private String email;
    private String password;
    private String role;
    private String expertise;

}
