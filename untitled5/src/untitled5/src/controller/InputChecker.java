package controller;

import view.JungleView;

class InputChecker {

    static boolean startOrLoad(String string) {
        if (string.equals("START") || string.equals("LOAD")) return false;
        else {
            JungleView.message("Please input start or load");
            return true;
        }
    }
}
