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
@Table(name = "RESUME", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_RESUME_PERSONAL_DATA", columnNames = {"PERSONAL_DATA_ID"})
})
public class Resume {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @OneToOne(optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name="PERSONAL_DATA_ID")
    private PersonalData personaldata;

    @ManyToOne(optional = false)
    @JoinColumn(name="WORKER_ID")
    private Person worker;

    @OneToMany(mappedBy = "resume", fetch = FetchType.EAGER)
    private Set<Review> reviews = new HashSet<>();

    public Resume(PersonalData personalData, Person person) {
        this.personaldata = Objects.requireNonNull(personalData);
        this.worker = Objects.requireNonNull(person);
        this.personaldata.setResume(this);
    }

    public Resume(int id) {
        this.id=id;
    }


}