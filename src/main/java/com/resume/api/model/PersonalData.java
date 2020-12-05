package com.resume.api.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = "id")
@Table(name = "PERSONAL_INFO", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_PERSONAL_INFO_RESUME", columnNames = {"RESUME_ID"})
})
public class PersonalData {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(optional = false)
    @JoinColumn(name="RESUME_ID")
    private Resume resume;
}
