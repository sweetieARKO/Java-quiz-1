package Week2.example;

public abstract class Shape {
    public double calculateArea() {
        return 0;
    }

    public abstract double calculatePerimeter();

    class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    class Rectangle extends Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (length + width);
        }

    }

    public static class Main {
        public static void main(String[] args) {
            Circle circle = new Shape() {
                @Override
                public double calculatePerimeter() {
                    return 0;
                }
            }.new Circle(5);
            System.out.println("Circle Area: " + circle.calculateArea());
            System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

            Rectangle rectangle = new Shape() {
                @Override
                public double calculatePerimeter() {
                    return 0;
                }
            }.new Rectangle(4, 5);
            System.out.println("Rectangle Area: " + rectangle.calculateArea());
            System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
        }
    }
}
