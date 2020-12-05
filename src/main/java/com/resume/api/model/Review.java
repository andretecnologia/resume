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
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CV_ID")
    private CV cv;

    private Integer score;
}
