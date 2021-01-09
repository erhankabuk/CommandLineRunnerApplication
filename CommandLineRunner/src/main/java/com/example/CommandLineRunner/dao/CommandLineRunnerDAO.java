package com.example.CommandLineRunner.dao;

import com.example.CommandLineRunner.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandLineRunnerDAO extends JpaRepository<Store, Long> {

Store findByName(String name);

}
