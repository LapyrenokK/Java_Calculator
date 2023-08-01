import java.util.List;

public class Application {

    private final Reader reader = new ConsoleReader();
    private final Writer writer = new ConsoleWriter();
    private final OperationService operationService = new OperationService();


    public void start() {
        while (true) {
            writer.write("Enter num1...");
            double num1 = reader.readNum();

            writer.write("Choose type: +, -, *, /");
            String type = reader.readType();

            writer.write("Enter num2...");
            double num2 = reader.readNum();


            Operation operation = new Operation(num1, num2, type);
            operation = operationService.calculate(operation);
            writer.write("Result = " + operation.getResult());

            writer.write("Continue ?... 1-yes, 2-no, 3-show history");
            double answer = reader.readNum();
            if (answer == 2) {
                break;
            } else if (answer == 3) {
                List<String> history = operationService.getHistory();
                for (String s : history) {
                    writer.write(s);
                }
            }
        }
    }
}
