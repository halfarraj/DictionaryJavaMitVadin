//package com.dictionary.dictionary;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@Slf4j
//public class LoadDatabase {
//
//  @Bean @Autowired
//  CommandLineRunner initDatabase(DicRepository repository) {
//    return args -> {
//
//
//      log.info("Preloading" + repository.save(new Database("wort","كلمة")));
//      log.info("Preloading" + repository.save(new Database("hand","يد")));
//
//    };
//  }
//}