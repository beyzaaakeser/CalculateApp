package com.calculate.repository;

import com.calculate.domain.Calculate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculateRepository extends JpaRepository<Calculate,Long> {

    List<Calculate> findByOperation(String operation);
}
