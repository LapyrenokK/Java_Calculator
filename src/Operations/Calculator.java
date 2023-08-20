package Operations;

import Readers.ConsoleReader;
import Readers.Reader;
import Registrations.Users;
import Writers.ConsoleWriter;
import Writers.Writer;

import java.util.List;

public class Calculator {

    private final Reader consoleReader = new ConsoleReader();
    private final Writer consoleWriter = new ConsoleWriter();
    private final OperationService operationService = new OperationService();


    public void calculation(Users user) {
        while (true) {
            consoleWriter.write("Enter num1...");
            double num1 = consoleReader.readDouble();

            consoleWriter.write("Choose type: +, -, *, /");
            String type = consoleReader.readString();

            consoleWriter.write("Enter num2...");
            double num2 = consoleReader.readDouble();


            Operation operation = new Operation(num1, num2, type);
            operation = operationService.calculate(operation,user);
            consoleWriter.write("Result = " + operation.getResult());

            consoleWriter.write("Continue ?... 1-yes, 2-no, 3-show history");
            double answer = consoleReader.readDouble();
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
