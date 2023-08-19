import OperationStorages.Operation;
import Readers.ConsoleReader;
import Readers.Reader;
import Writers.ConsoleWriter;
import Writers.Writer;

import java.util.List;

public class Application {

    private final Reader consoleReader = new ConsoleReader();
    private final Writer consoleWriter = new ConsoleWriter();
    private final OperationService operationService = new OperationService();


    public void start() {
        while (true) {
            consoleWriter.write("Enter num1...");
            double num1 = consoleReader.readNum();

            consoleWriter.write("Choose type: +, -, *, /");
            String type = consoleReader.readType();

            consoleWriter.write("Enter num2...");
            double num2 = consoleReader.readNum();


            Operation operation = new Operation(num1, num2, type);
            operation = operationService.calculate(operation);
            consoleWriter.write("Result = " + operation.getResult());

            consoleWriter.write("Continue ?... 1-yes, 2-no, 3-show history");
            double answer = consoleReader.readNum();
            if (answer == 2) {
                break;
            } else if (answer == 3) {
                List<String> history = operationService.getHistory();
                for (String s : history) {
                    consoleWriter.write(s);
                }
            }
        }
    }
}
