
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public double readNum() {
        return scanner.nextDouble();
    }

    @Override
    public String readType() {
        return scanner.next();
    }
}
