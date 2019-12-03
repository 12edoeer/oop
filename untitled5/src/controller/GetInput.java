package controller;

import java.util.Scanner;

public class GetInput {
    private static Scanner input;

	public static String Input(){
        input = new Scanner(System.in);
        return input.next();
    }
}

//Static function for getting input
