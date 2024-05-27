package com.example.application.views.game;

import java.util.Arrays;

import com.example.application.Player;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.application.webinterface;

import com.example.application.MainView;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Game")
@Route(value = "Game", layout = MainView.class)
public class GameView extends HorizontalLayout{

    private TextField name;
    private TextField choosenPlayer;
    private Button EnterGuess;
    private Random random;
    private List<Player> players;
    private List<Player> maskedplayers;
    private Grid<Player> grid = new Grid<>();

    public GameView() {

        grid.addColumn(Player::getName).setHeader("Player Name");
        grid.addColumn(Player::getVIPerson).setHeader("VIP Name");
        //grid.addColumn(player -> String.join(", ", player.getQuestions())).setHeader("Questions Asked");

        // Example players
        UI.getCurrent().getPage().executeJs(
                "return localStorage.getItem($0);",
                "vipName"
        ).then(String.class, value -> {
            if (value != null && !value.isEmpty()) {
                try {
                    choosenPlayer.setValue(value);
                }   catch (NumberFormatException e) {
                    System.err.println("Error parsing seed value: " + e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException("Error getting random names: ", e);
                }   
            } else {
                Notification.show("Please enter GameID");
                System.err.println("No gameid found in localStorage.");
            }
        });
        
        name = new TextField("Who you think you are");
        choosenPlayer = new TextField("Player Name");
        EnterGuess = new Button("Enter Guess");
        EnterGuess.addClickListener(e -> {
            Notification.show("Your Guess " + name.getValue()+" was " +(guess(name.getValue()) ? "correct" : "incorrect"));
            if(guess(name.getValue())){
                openWinDialog();
            };
        });
        EnterGuess.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.START, name, choosenPlayer, EnterGuess);

        add(name,choosenPlayer,EnterGuess,grid);
        getVIP_List(players);
        }

        public void setPlayers(String[] vipNames) {
            this.players = Arrays.asList(
            new Player("Alice", vipNames[0]),
            new Player("Bob", vipNames[1]),
            new Player("Charlie", vipNames[2]),
            new Player("Dana", vipNames[3])
        );
            this.maskedplayers = players.stream()
                    .map(player -> new Player(player.getName(), player.getVIPerson()))
                    .collect(Collectors.toList());
        grid.setItems(maskVIPNames(maskedplayers));
        }

        private List<Player> maskVIPNames(List<Player> maskedplayers){
        for(Player p : maskedplayers){
            if(p.getName().equals(choosenPlayer.getValue()))
                p.setVIPerson("****");
        }
        return maskedplayers;
        }
    /**
     * 
     * @return
     */
    private void getVIP_List(List<Player> players){
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
                    if(name2.length>0)
                     setPlayers(name2);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing seed value: " + e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException("Error getting random names: ", e);
                }
            } else {
                Notification.show("Please enter GameID");
                System.err.println("No gameid found in localStorage.");
            }
        });
    }


    private boolean guess(String value){
        if (value!=null && !players.isEmpty())
            for(Player p : players){
                if(p.getName().equals(choosenPlayer.getValue()))
                    if(p.getVIPerson().equals(value)){
                    return true;
            }
        }
        return false;
    }
    public void openWinDialog() {
        Dialog openWinDialog = new Dialog();
        openWinDialog.add(new VerticalLayout(new H1("(❁´◡`❁) YOU WIN!"), new Span("Thanks for visiting our WhoAmI, try a new Game-ID. 🎉")));
        Button closeButton = new Button("Close", event -> {
            openWinDialog.close();
        });
        openWinDialog.add(closeButton);
        openWinDialog.open();
    }

}
