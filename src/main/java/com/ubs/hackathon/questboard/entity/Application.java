package com.ubs.hackathon.questboard.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Application extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quest quest;

//    private Integer questId;

    private String applicantComments;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ubs_user_id", referencedColumnName = "id")
    private UbsUser user;

    private String submittedDate;
    private Boolean isSelected;
    private String status;
    private String sponsorComments;
}
