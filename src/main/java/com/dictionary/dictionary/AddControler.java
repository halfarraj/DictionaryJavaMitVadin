package com.dictionary.dictionary;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "add")
public class AddControler extends VerticalLayout {
    @Autowired
    private DicRepository dicRepository;

    public AddControler(DicRepository dicRepository) {
        Database database = new Database();
        this.dicRepository = dicRepository;
        TextField arabic = new TextField("Arabic");
        TextField german = new TextField("German");
        Button add = new Button("Add");

        String arabicValue = arabic.getValue();
        String germanValue = german.getValue();

        add.addClickListener(e -> {

            String ara = arabic.getValue();
            String ger = german.getValue();

            try {
                dicRepository.save(new Database(ger, ara));
                Notification.show("Die Daten wurde gespeichert.", 1000, Notification.Position.BOTTOM_CENTER);
                System.out.println(ger +" --- "+ ara);
            } catch (Exception s) {
                s.printStackTrace();
            }


        });
        add(german, arabic, add);
    }
}