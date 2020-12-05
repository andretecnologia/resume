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
        @UniqueConstraint(name = "UNQ_PERSONAL_INFO_CV", columnNames = {"CV_ID"})
})
public class PersonalData {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToOne(optional = false)
    @JoinColumn(name="CV_ID")
    private CV cv;
}
