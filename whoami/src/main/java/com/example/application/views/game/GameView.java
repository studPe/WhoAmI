package com.example.application.views.game;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.application.Player;
import com.example.application.Application;
import java.util.List;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Game")
@Route(value = "Game", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)

public class GameView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public GameView() {
    	 Grid<Player> grid = new Grid<>();
         grid.addColumn(Player::getName).setHeader("Player Name");
         grid.addColumn(Player::getVIPerson).setHeader("VIP Name");
         //grid.addColumn(player -> String.join(", ", player.getQuestions())).setHeader("Questions Asked");

         // Example players
         List<Player> players = Arrays.asList(
             new Player("Alice"),
             new Player("Bob"),
             new Player("Charlie"),
             new Player("Dana")
         );

         grid.setItems(players);
        name = new TextField("Who you think you are");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
        sayHello.addClickShortcut(Key.ENTER);

        setMargin(true);
        //setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name,grid);
    }


}
