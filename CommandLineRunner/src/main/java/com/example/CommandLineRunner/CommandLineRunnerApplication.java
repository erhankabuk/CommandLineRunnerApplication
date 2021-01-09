package com.example.CommandLineRunner;

import com.example.CommandLineRunner.repo.StoreRepo;
import com.example.CommandLineRunner.service.StoreService;
import com.example.CommandLineRunner.utility.StoreUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineRunnerApplication implements CommandLineRunner {

    @Autowired
    StoreRepo storeRepo;
    @Autowired
    StoreService storeService;
    @Autowired
    StoreUtility storeUtility;

    public static void main(String[] args) {
        SpringApplication.run(CommandLineRunnerApplication.class , args).close();
    }

    @Override
    public void run(String... args) throws Exception {
        storeUtility.commandMethod();
    }
}








