package com.klasix12;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        FileChanger fileChanger = new FileChanger();
        InputParser inputParser = new InputParser();

        printer.printWelcomeMessage();

        List<String> ideList = fileChanger.getIDEs();
        printer.printIDEChoice(ideList);

        int userIdeIntChoice = inputParser.getUserInt(ideList.size());

        fileChanger.activateIde(ideList.get(userIdeIntChoice - 1));

        printer.printSuccessfully();
    }
}