package com.resume.api.model;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = "id")
public class Resume {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @OneToOne(mappedBy = "resume", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonalData personalData;

    @ManyToOne(optional = false)
    @JoinColumn(name="PERSON_ID")
    private Person person;

    @OneToMany(mappedBy = "resume", fetch = FetchType.EAGER)
    private Set<Review> reviews = new HashSet<>();


    public Resume(PersonalData personalData, Person person) {
        this.personalData = Objects.requireNonNull(personalData);
        this.person = Objects.requireNonNull(person);
        this.personalData.setResume(this);
    }

    public Resume(int id) {
        this.id=id;
    }


}