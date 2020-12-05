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
public class CV {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @OneToOne(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonalData personalData;

    @ManyToOne(optional = false)
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(mappedBy = "cv", fetch = FetchType.EAGER)
    private Set<Review> reviews = new HashSet<>();


    public CV(PersonalData personalData, User user) {
        this.personalData = Objects.requireNonNull(personalData);
        this.user = Objects.requireNonNull(user);
        this.personalData.setCv(this);
    }

    public CV(int id) {
        this.id=id;
    }


}