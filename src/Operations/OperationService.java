package Operations;

import Registrations.Users;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OperationService {

    private final OperationStorage storage = new FileOperationStorage();

    File file;




    public Operation calculate(Operation operation, Users users) {

        switch (operation.getType()) {
            case "+":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operation.setDate(LocalDate.now());
                file = new File("res/UsersHistory/"+users.getUserName()+".txt");
                storage.save(operation,file);
                return operation;
            case "-":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operation.setDate(LocalDate.now());
                file = new File("res/UsersHistory/"+users.getUserName()+".txt");
                storage.save(operation,file);
                return operation;
            case "*":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operation.setDate(LocalDate.now());
                file = new File("res/UsersHistory/"+users.getUserName()+".txt");
                storage.save(operation,file);
                return operation;
            case "/":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operation.setDate(LocalDate.now());
                file = new File("res/UsersHistory/"+users.getUserName()+".txt");
                storage.save(operation,file);
                return operation;
        }
        return null;
    }

    public List<String> getHistory() {
        List<Operation> all = storage.findAll(file);
        List<String> result = new ArrayList<>();
        for (Operation op : all) {
            result.add("Result [" +
                    op.getNum1() +
                    " " + op.getType() +
                    " " + op.getNum2() +
                    " = " + op.getResult() +
                    " ... " + op.getDate() +
                    "]");
        }
        return result;
    }

}

