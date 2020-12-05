package com.resume.api.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "REVIEWER_ID")
    private Person reviewer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    private Integer score;
}
