package com.example.application.views.game;

import java.util.Arrays;

import com.example.application.Player;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import com.example.application.webinterface;

import com.example.application.MainView;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Game")
@Route(value = "Game", layout = MainView.class)
public class GameView extends HorizontalLayout{

    private TextField name;
    private Button EnterGuess;
    private Random random;
    static Grid<Player> grid = new Grid<>();

    public GameView() {

        grid.addColumn(Player::getName).setHeader("Player Name");
        grid.addColumn(Player::getVIPerson).setHeader("VIP Name");
        //grid.addColumn(player -> String.join(", ", player.getQuestions())).setHeader("Questions Asked");

        // Example players

        name = new TextField("Who you think you are");
        EnterGuess = new Button("Enter Guess");
        EnterGuess.addClickListener(e -> {
            Notification.show("Your Guess " + name.getValue()+"was " +(guess() ? "correct" : "incorrect"));
        });
        EnterGuess.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.START, name, EnterGuess);

        add(name,EnterGuess,grid);
        getVIP_List();
    }
    public static void setPlayers(String[] vipNames){
        List<Player> players = Arrays.asList(
                new Player("Alice",vipNames[0]),
                new Player("Bob",vipNames[1]),
                new Player("Charlie",vipNames[2]),
                new Player("Dana",vipNames[3])
        );
        grid.setItems(players);
    }
    /**
     * @return
     */
    private static void getVIP_List(){
        // Fetch the gameid from localStorage
        UI.getCurrent().getPage().executeJs(
                "return localStorage.getItem($0);",
                "gameid"
        ).then(String.class, value -> {
            if (value != null && !value.isEmpty()) {
                try {
                    int seedInt = Integer.parseInt(value); // Convert string to integer
                    String[] name2 = webinterface.getRandomName(seedInt);
                    // Use the names as needed, e.g., update UI or process data
                    setPlayers(name2);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing seed value: " + e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException("Error getting random names: ", e);
                }
            } else {
                System.err.println("No gameid found in localStorage.");
            }
        });
    }


    private boolean guess(){
        this.random = new Random();
        boolean isCorrect = random.nextBoolean();
        return isCorrect;
    }

}
