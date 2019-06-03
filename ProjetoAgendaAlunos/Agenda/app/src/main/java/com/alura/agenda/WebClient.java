package com.alura.agenda;

import android.util.JsonReader;

import com.alura.agenda.modelo.Aluno;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class WebClient {
    public String post(String json){
        try {
            URL url = new URL("https://177.220.18.47:8080/APIAndroid/webresources/generic/incluirAluno");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);
            //connection.setDoInput(true);

            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);

            connection.connect();

            Scanner scanner = new Scanner(connection.getInputStream());
            String  resposta = scanner.next();

            return resposta;



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

//    public String consultaAlunos(){
//        try {
//            URL url = new URL("https://177.220.18.47:8080/APIAndroid/webresources/generic/consultar");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
////            connection.setRequestProperty("Content-type", "application/json");
////            connection.setRequestProperty("Accept", "application/json");
//
//            connection.connect();
//
//            if (connection.getResponseCode() == 200) {
//                InputStream responseBody = connection.getInputStream();
//                InputStreamReader responseBodyReader =
//                        new InputStreamReader(responseBody, "UTF-8");
//
//                JsonReader jsonReader = new JsonReader(responseBodyReader);
//                jsonReader.beginObject(); // Start processing the JSON object
//
//                while (jsonReader.hasNext()) { // Loop through all keys
//                    String key = jsonReader.nextName(); // Fetch the next key
//                    if (key.equals("organization_url")) { // Check if desired key
//                        // Fetch the value as a String
//                        String value = jsonReader.nextString();
//
//                        // Do something with the value
//                        // ...
//
//                        break; // Break out of the loop
//                    } else {
//                        jsonReader.skipValue(); // Skip values of other keys
//                    }
//                }
//            } else {
//
//            }
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//    }
}