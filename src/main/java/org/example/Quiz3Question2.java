package org.example;

public class Quiz3Question2 {

    public static void main(String[] args) {
        int age =   11;
        switch (age) {

            case 12:
                System.out.println("You are a child.");
                break;
            case 19:
                System.out.println("You are a teenager.");
                break;
            case 59:
                System.out.println("You are an adult.");
                break;
            default:
                // Default case for ages 60 and above
                if (age >= 60) {
                    System.out.println("You are a senior citizen.");
                } else {
                    System.out.println("Invalid age.");
                }
        }
    }
}
    
