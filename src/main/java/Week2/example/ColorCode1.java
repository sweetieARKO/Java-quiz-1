package Week2.example;

public class ColorCode1 {
    public static final ColorCode1 RED = new ColorCode1("Red");
    public static final ColorCode1 GREEN = new ColorCode1("Green");
    public static final ColorCode1 BLUE = new ColorCode1("Blue");
    public static final ColorCode1 YELLOW = new ColorCode1("Yellow");
    public static final ColorCode1 BLACK = new ColorCode1("Black");

    private final String colorCode;

    ColorCode1(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return colorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorCode1 colorCode1 = (ColorCode1) o;
        return colorCode.equals(colorCode1.colorCode);
    }

    @Override
    public int hashCode() {
        return colorCode.hashCode();
    }
}
