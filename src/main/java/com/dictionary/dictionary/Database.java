package com.dictionary.dictionary;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class Database {

    private @Id @GeneratedValue Long id;

    private String theWorldInGerman;

    private String theTranslateToArabic;

    public Database() {
    }

    public Database(String theWorldInGerman, String theTranslateToArabic) {
        this.theWorldInGerman = theWorldInGerman;
        this.theTranslateToArabic = theTranslateToArabic;

    }


}
