package com.example.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest{

    @Test
    void setVIPerson() {
        assertAll(
                () -> {
                    // Create a Player object
                    String expectedName = "John Doe";
                    String expectedVIPPerson = "VIP Person";
                    Player player = new Player(expectedName, expectedVIPPerson);

                    // Verify that the getters return the correct values
                    assertEquals(expectedVIPPerson, player.getVIPerson());

                    // Change the VIP person
                    String newVIPPerson = "New VIP Person";
                    player.setVIPerson(newVIPPerson);

                    // Verify that the getter returns the new value
                    assertEquals(newVIPPerson, player.getVIPerson());
                }
        );
    }

    @Test
    void getName() {
// Create a Player object
        String expectedName = "John Doe";
        String expectedVIPPerson = "VIP Person";
        Player player = new Player(expectedName, expectedVIPPerson);

        // Verify that the getters return the correct values
        assertEquals(expectedName, player.getName());
    }

    @Test
    void getVIPerson() {
        assertAll(
                () -> {
                    // Create a Player object
                    String expectedName = "John Doe";
                    String expectedVIPPerson = "VIP Person";
                    Player player = new Player(expectedName, expectedVIPPerson);

                    // Verify that the getters return the correct values
                    assertEquals(expectedVIPPerson, player.getVIPerson());
                }
        );
    }
}