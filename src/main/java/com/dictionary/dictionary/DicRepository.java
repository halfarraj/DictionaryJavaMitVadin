package com.dictionary.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DicRepository extends JpaRepository<Database, Long> {

    Database findByTheTranslateToArabic(String theTranslateToArabic);

    Database findByTheWorldInGerman(String theWorldInGerman);


    List<Database> findAll();


}
