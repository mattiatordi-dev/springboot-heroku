package com.example.demo.repository;

import com.example.demo.model.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<test, Integer> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM test t ",nativeQuery = true)
    List<test> getAllTest();
}
