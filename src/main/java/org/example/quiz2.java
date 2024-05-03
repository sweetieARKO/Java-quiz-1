package org.example;

public class quiz2 {


    public static void main(String[] args){
    printNameDetails ("Abigail" , "Arko");
    }
    public static void  printNameDetails(String firstName, String LastName){
     String fullName = firstName +" "+ LastName;
     int firstNameLength = firstName.length();
     int  lastNameLength = LastName.length();
        System.out.println("Hello My name is " + fullName);
        System.out.println("There are " + firstNameLength + " letters in my first name and " + lastNameLength + " letters in my last name"  );


    }
}
