package com.vsked.demo30;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SequenceTestRepository extends JpaRepository<SequenceTest,Long>,JpaSpecificationExecutor<SequenceTest> {
}
