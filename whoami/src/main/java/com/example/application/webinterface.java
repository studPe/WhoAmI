package com.example.application;

import com.example.application.MainView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class webinterface {
    private static final String API_URL = "http://127.0.0.1:5000/random-name";
    private static final Logger log = LoggerFactory.getLogger(webinterface.class);

    public static String getRandomName() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();
        JSONObject jsonObject = new JSONObject(content.toString());
        return jsonObject.getString("name");

        //return content.toString();
    }

    public static String[] getRandomName(int seed) throws Exception {
        URL url = new URL(API_URL+"/"+seed);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try{
            conn.connect();
        }
        catch (ConnectException e){
            com.example.application.MainView.offlineDialog();
            return new String[]{"Leonardo DiDisconnectedCaprio","Meryl Can't-Streep-Online.","Taylor Can't-Swift.","Keanu Not-Connected-Reeves."};
        }

        // Check if the connection is successful
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            System.out.println("HttpResponseCode: " + responseCode);
            return new String[]{"NoConnection","NoConnection","NoConnection","NoConnection"};
        } else {
            // Read data from the input stream
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }
            reader.close();

            // Convert JSON string to JSONObject
            JSONObject jsonObject = new JSONObject(jsonResponse.toString());

            // Get the JSONArray from JSONObject
            JSONArray jsonArray = jsonObject.getJSONArray("name");

            // Prepare the String array
            String[] names = new String[jsonArray.length()];

            // Fill the String array with names
            for (int i = 0; i < jsonArray.length(); i++) {
                names[i] = jsonArray.getString(i);
            }
            return names;
    }}
}

