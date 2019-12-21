package com.example.albit_test.repository;

import com.example.albit_test.model.Albit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbitRepository extends JpaRepository<Albit, Long> {
}
