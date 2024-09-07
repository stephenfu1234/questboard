package com.ubs.hackathon.questboard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Quest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String category;
    private String summary;
    private String techStack;
    private String startDate;
    private String closingDate;
    private Integer kudosPoints;
    private String status;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sponsor_id", referencedColumnName = "id")
    private UbsUser sponsor;

    @OneToMany(
            mappedBy = "quest",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Application> applications = new ArrayList<>();

    public void addApplication(Application application) {
        applications.add(application);
        application.setQuest(this);
    }

    public void removeApplication(Application application) {
        applications.remove(application);
        application.setQuest(null);
    }

}
