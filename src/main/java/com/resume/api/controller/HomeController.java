package com.resume.api.controller;

import com.resume.api.model.*;
import com.resume.api.repository.ResumeRepository;
import com.resume.api.repository.ReviewRepository;
import com.resume.api.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    final PersonRepository personRepository;

    final ResumeRepository resumeRepository;

    final ReviewRepository reviewRepository;

    public HomeController(PersonRepository personRepository, ResumeRepository resumeRepository, ReviewRepository reviewRepository) {
        this.personRepository = personRepository;
        this.resumeRepository = resumeRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public String start() {
        run();
        return "http://localhost:8080/h2-database!";
    }

    private void run() {

        generateSampleData("John", "123456-7", "john_user1", "1234", "John Smith", Gender.MALE );
        generateSampleData("Peter", "654321-7", "peter_user2", "1234", "Peter Johnson", Gender.MALE );
        generateSampleData("Mary", "123456-7", "mary_user3", "1234", "Mary Jones", Gender.FEMALE );

        Review review = Review.builder()
                .person(new Person(1))
                .resume(new Resume(1))
                .score(10)
        .build();

        reviewRepository.save(review);

        Resume resume = resumeRepository.findById(1).get();
        System.out.println(resume.getReviews().size());
    }

    private void generateSampleData(String firstName, String document, String userName, String password, String fullName, Gender gender) {
        Account account = Account.builder()
                .userName(userName)
                .password(password)
                .build();

        Person person = new Person(firstName, document, account);

        Person savePerson = personRepository.save(person);

        PersonalData personalData = PersonalData.builder()
                .fullName(fullName)
                .gender(gender)
                .build();

        resumeRepository.save(new Resume(personalData, savePerson));
    }
}
