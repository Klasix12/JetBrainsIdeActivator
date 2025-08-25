package com.klasix12;

import java.util.List;

public class Printer {

    public void printWelcomeMessage() {
        System.out.println("Welcome to JetBrainsIDEActivator!\n");
    }

    public void printIDEChoice(List<String> IDEs) {
        System.out.println("Please select the IDE for which you want to get a free period:");
        for (int i = 0; i < IDEs.size(); i++) {
            System.out.println(i + 1 + " - " + IDEs.get(i));
        }
    }

    public void printSuccessfully() {
        System.out.println("The activation of the trial period was successful.\nThanks for using JetBrainsIDEActivator.");
    }
}
