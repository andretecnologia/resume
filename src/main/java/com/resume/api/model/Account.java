package com.resume.api.model;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = "id")
@Table(name = "ACCOUNT", uniqueConstraints = {
        @UniqueConstraint(name = "UNQ_ACCOUNT_PERSON", columnNames = {"PERSON_ID"})
})
public class Account {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String userName;
    private String password;

    @OneToOne(optional = false)
    @JoinColumn(name="PERSON_ID")
    private Person person;

    public Account(int id) {
        this.id = id;
    }
}