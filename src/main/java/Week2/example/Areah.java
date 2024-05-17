package Week2.example;

import java.util.Scanner;

class Area {
    private double length;
    private double breadth;

    public Area(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double returnArea() {
        return length * breadth;
    }
}

public class Areah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter length of rectangle:");
            double length = scanner.nextDouble();
            if (length <= 0) {
                throw new IllegalArgumentException("Length must be a positive number.");
            }

            System.out.println("Enter breadth of rectangle:");
            double breadth = scanner.nextDouble();
            if (breadth <= 0) {
                throw new IllegalArgumentException("Breadth must be a positive number.");
            }

            Area rectangle = new Area(length, breadth);
            double area = rectangle.returnArea();
            System.out.println("Area of the rectangle: " + area);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Input must be numeric.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
