package com.resume.api.model;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = "id")
public class Account {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String userName;
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Person person;

    public Account(int id) {
        this.id = id;
    }
}