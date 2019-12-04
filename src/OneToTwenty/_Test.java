package OneToTwenty;
import java.util.function.DoubleBinaryOperator;

public class _Test {

    public static void main(String[] args) {
        Size size = Size.valueOf("SMALL");
        System.out.println(size.name());
        System.out.println(size.toString());
        System.out.println(size.getAbbreviation());
        System.out.println(Size.SMALL);
        for (Operation op : Operation.values()) {
            double x = 1.1;
            double y = 2.2;
            System.out.println("x" + op.getSymbol() + "y=" + op.apply(x, y));
        }
        System.out.println("----------------");

        StringBuilder sb = new StringBuilder();
        sb.append(0);
        add(sb);
        System.out.println(sb);
    }
    public static void add(StringBuilder a){
        a.append(1);
    }
}

enum Size {
    SMALL("S"), LARGE("L"), MEDIA("M");
    private String abbreviation = null;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
}

enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    public String getSymbol() {
        return symbol;
    }

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
