package Week1;

public class quiz3Question4 {

        public static void main(String[] args) {
            // Print a triangle pattern
            System.out.println("Triangle Pattern:");
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }

            // Simulate a countdown from 10 to 1
            System.out.println("\nCountdown:");
            int countdown = 10;
            while (countdown >= 1) {
                System.out.println(countdown);
                countdown--;
            }
        }
    }

