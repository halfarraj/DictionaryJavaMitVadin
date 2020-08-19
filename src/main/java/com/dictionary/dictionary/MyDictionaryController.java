package com.dictionary.dictionary;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import org.apache.logging.log4j.core.layout.HtmlLayout;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "such")
public class MyDictionaryController extends VerticalLayout {

    @Autowired
    private DicRepository dicRepository;


    public MyDictionaryController(DicRepository dicRepository) {

        Database database = new Database();
        this.dicRepository = dicRepository;

        Label label = new Label();
        label.setText(" Arabische_Deutsche Wörterbuch ");

        TextField world = new TextField();
        world.setPlaceholder("wort");
        TextArea arabicResult = new TextArea();


        TextArea germanResult = new TextArea();


        Button translate = new Button("Translate");


        arabicResult.setWidth("400px");
        arabicResult.setHeight("100px");

        germanResult.setWidth("400px");
        germanResult.setHeight("100px");


        translate.addClickListener(e -> {


            String worldValue = world.getValue();

            try {

                Database searchForArabic = dicRepository.findByTheTranslateToArabic(worldValue);
                if (worldValue != null) {

                    if (!searchForArabic.equals(worldValue)) {

                        arabicResult.setValue(searchForArabic.getTheWorldInGerman());


                    }
//                    else result1.setValue("Bitte gib ein wort zuerst :) ");
                }
            } catch (Exception exc) {

                System.out.println(exc.getMessage());
                arabicResult.setValue(" الرجاء ادخال كلمة ليتم ترجمتها");

            }
            try {


                Database searchForGerman = dicRepository.findByTheWorldInGerman(worldValue.toLowerCase());

                if (worldValue != null) {
                    if (!searchForGerman.equals(worldValue.toLowerCase())) {

                        germanResult.setValue(searchForGerman.getTheTranslateToArabic());


                    }
//                    else result.setValue("Bitte gib ein wort zuerst :) ");


                }

            } catch (Exception exc) {

                System.out.println(exc.getMessage());
                germanResult.setValue("Bitte gib ein Wort zur Übersetzung ");
            }
        });


        add(label, world, translate, arabicResult, germanResult);

    }

}
