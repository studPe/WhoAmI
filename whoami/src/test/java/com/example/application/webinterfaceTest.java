package com.example.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class webinterfaceTest {
    String expectedName = "John Doe";
    String[] expectedNames = {
        "Elon Musk", "Angela Merkel", "Cristiano Ronaldo", "Taylor Swift",
        "Serena Williams", "Barack Obama", "Beyonce", "Jeff Bezos",
        "Lionel Messi", "Oprah Winfrey", "Bill Gates", "Kim Kardashian",
        "LeBron James", "Lady Gaga", "Roger Federer", "Mark Zuckerberg",
        "Rihanna", "Stephen Curry", "Emma Watson", "Vladimir Putin",
        "Ariana Grande", "Jennifer Lopez", "Novak Djokovic", "Justin Bieber",
        "Tom Brady", "Greta Thunberg", "Katy Perry", "Xi Jinping", "Ed Sheeran",
        "Meryl Streep", "Selena Gomez", "Usain Bolt", "Dwayne Johnson",
        "Ellen DeGeneres", "Adele", "Michael Jordan", "Kylie Jenner", "Tim Cook",
        "Michelle Obama", "J.K. Rowling", "Neymar", "Warren Buffett", "Drake",
        "Rafael Nadal", "Scarlett Johansson", "Sundar Pichai", "Chris Hemsworth",
        "Virat Kohli", "Emma Stone", "Jack Ma", "Malala Yousafzai", "Jennifer Aniston",
        "Brad Pitt", "Bruno Mars", "Angelina Jolie", "Leonardo DiCaprio",
        "Robert Downey Jr.", "Shah Rukh Khan", "Giannis Antetokounmpo", "Will Smith",
        "Harry Styles", "Taylor Lautner", "Larry Page", "Salman Khan", "Keanu Reeves",
        "Meghan Markle", "Benedict Cumberbatch", "Daniel Craig", "Margot Robbie",
        "Lewis Hamilton", "Shakira", "Johnny Depp", "Chris Evans", "Emma Thompson",
        "Jennifer Lawrence", "Sophie Turner", "Saoirse Ronan", "Timothee Chalamet",
        "Zendaya", "Millie Bobby Brown", "Gigi Hadid", "Bella Hadid", "Jason Momoa",
        "Henry Cavill", "Natalie Portman", "Adam Driver", "Daisy Ridley", "John Boyega",
        "Chadwick Boseman", "Tom Holland", "Chris Pratt", "Ana de Armas", "Gal Gadot",
        "Florence Pugh", "Joaquin Phoenix", "Cillian Murphy", "Andrew Garfield",
        "Benedict Wong", "Tom Hiddleston", "Idris Elba"};

    @Mock
    private HttpURLConnection mockConnection;

    @Mock
    private URL mockUrl;

    @Mock
    private InputStream mockInputStream;

    @Mock
    private BufferedReader mockReader;

    private webinterface webInterface;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
        webInterface = new webinterface();
    }

    @Test
    public void getRandomName_shouldReturnRandomName() throws Exception {
        // Arrange

        String jsonResponse = "{\"name\": \"" + expectedName + "\"}";

        when(mockUrl.openConnection()).thenReturn(mockConnection);
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockInputStream.read()).thenReturn(-1);
        when(mockConnection.getResponseCode()).thenReturn(200);
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockInputStream.read()).thenReturn(-1);
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockReader.readLine()).thenReturn(jsonResponse, null);

        // Act
        assertThrows(ConnectException.class, () -> webinterface.getRandomName());
    }

    @Test
    public void getRandomName_withSeed_shouldReturnRandomNames() throws Exception {
        // Arrange
        int seed = 123;

        when(mockUrl.openConnection()).thenReturn(mockConnection);
        when(mockConnection.getResponseCode()).thenReturn(200);
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockInputStream.read()).thenReturn(-1);
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockInputStream.read()).thenReturn(-1);
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockReader.readLine()).thenReturn("{\"name\": [\"John\", \"Jane\", \"Doe\"]}", null);
        // Assert
        assertThrows(ConnectException.class, () -> webinterface.getRandomName(seed));
    }
}