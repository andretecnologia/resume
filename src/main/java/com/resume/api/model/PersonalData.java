package com.resume.api.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = "id")
@Table(name = "PERSONAL_DATA")
public class PersonalData {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "personaldata", cascade = CascadeType.ALL, orphanRemoval = true)
    private Resume resume;
}
