package com.resume.api.repository;

import com.resume.api.model.CV;
import com.resume.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<CV, Integer> {
}
