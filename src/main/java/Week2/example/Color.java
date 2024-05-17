package Week2.example;

public enum Color {
    RED("#FF0000"),
    GREEN("#008000"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00"),
    BLACK("#000000");

    private final String colorCode;

    Color(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }

    public static void printColorAndCode() {
        for (Color color : Color.values()) {
            System.out.println(color.name() + ": " + color.getColorCode());
        }
    }
}
