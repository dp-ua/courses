package com.epam.proofy;

import com.jsunsoft.http.ResponseException;
import io.proofy.java.ProofyApi;

public class App {

    public static void main(String[] args) {
        String uri = "https://api.proofy.io/verifyaddr?aid=9&key=testKey&email=test@test.io";

        ProofyApi proofyApi = new ProofyApi("9", "apiKey");

        try{
            proofyApi.emailCheck("mail@mail");
        }catch (ResponseException e) {
            System.err.println("Error. Answer from API: " + e.getStatusCode()+ e.toString());
        }


    }
}
