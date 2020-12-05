package com.resume.api.controller;

import com.resume.api.model.*;
import com.resume.api.repository.CVRepository;
import com.resume.api.repository.ReviewRepository;
import com.resume.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController implements CommandLineRunner {

    final UserRepository userRepository;

    final CVRepository cvRepository;

    final ReviewRepository reviewRepository;

    public HomeController(UserRepository userRepository, CVRepository cvRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.cvRepository = cvRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public String welcomeMessage() {
        return "Success!";
    }

    @Override
    public void run(String... args) throws Exception {

        geraDado("user1", "João", Genero.MASCULINO);
        geraDado("user2", "Pedro", Genero.MASCULINO);
        geraDado("user3", "Maria", Genero.FEMININO);

        Review review = Review.builder()
                .user(new User(1))
                .cv(new CV(1))
                .score(10)
        .build();

        reviewRepository.save(review);

        CV cv = cvRepository.findById(1).get();
        System.out.println(cv.getReviews().size());
    }

    private void geraDado(String userName, String name, Genero genero) {
        User user = User.builder()
                .userName(userName)
                .build();

        userRepository.save(user);

        PersonalData personalData = PersonalData.builder()
                .name(name)
                .genero(genero)
                .build();

        cvRepository.save(new CV(personalData, user));
    }
}
