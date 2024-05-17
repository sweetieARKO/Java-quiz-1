package Week2.example;

import java.util.Scanner;

public class question4 {
    public int divide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by 0 is not allowed");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter first number");
            int num1 = scanner.nextInt();
            System.out.println("Enter second number");
            int num2 = scanner.nextInt();
            System.out.println(num1 + num2);
            if (num2 <= 0) {
                throw new IllegalArgumentException("Second number must be a positive number.");
            }
            question4 obj = new question4();
            int result = obj.divide(num1,num2);
            System.out.println("Result is "+ result );

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Input must be an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

        }


