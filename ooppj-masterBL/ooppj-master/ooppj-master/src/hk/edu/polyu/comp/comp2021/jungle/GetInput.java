package hk.edu.polyu.comp.comp2021.jungle;

import java.util.Scanner;

public class GetInput {
    private static Scanner input;

	public static String Input(){
        input = new Scanner(System.in);
        return input.next();
    }
}

//Static function for getting input
