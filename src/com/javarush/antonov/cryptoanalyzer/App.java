package com.javarush.antonov.cryptoanalyzer;

import com.javarush.antonov.cryptoanalyzer.cipher.Caesar;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args){
        boolean flag = true;
        Caesar caesar = Caesar.get();
        while(flag) {
            try {
                caesar.encrypt("newFile.txt", 44, "res.txt");
                flag = false;
            } catch (FileNotFoundException e) {
                System.out.println("FIND");
            }
        }
    }
}
