package com.resume.api.model;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = "id")
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    private String firstName;

    private String documentId;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Account account;

    public Person(String firstName, String documentId, Account account) {
        this.firstName = Objects.requireNonNull(firstName);
        this.documentId = Objects.requireNonNull(documentId);
        this.account = Objects.requireNonNull(account);
        this.account.setPerson(this);
    }

    public Person(int id) {
        this.id = id;
    }
}