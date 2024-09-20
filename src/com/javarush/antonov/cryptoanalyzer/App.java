package com.javarush.antonov.cryptoanalyzer;

import com.javarush.antonov.cryptoanalyzer.demonstration.ControllerConsole;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        ControllerConsole controllerConsole = ControllerConsole.get();
        controllerConsole.start();
    }
}