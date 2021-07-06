package com.vsked.repository;

import com.vsked.entity.StudentScore;
import com.vsked.entity.StudentScoreKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScore, StudentScoreKey> {
}
