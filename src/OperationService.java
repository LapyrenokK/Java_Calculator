import OperationStorages.ArrayOperationStorage;
import OperationStorages.FileOperationStorage;
import OperationStorages.Operation;
import OperationStorages.OperationStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class OperationService {

    private final OperationStorage storage = new FileOperationStorage();


    public Operation calculate(Operation operation) {

        switch (operation.getType()) {
            case "+":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operation.setDate(LocalDate.now());
                storage.save(operation);
                return operation;
            case "-":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operation.setDate(LocalDate.now());
                storage.save(operation);
                return operation;
            case "*":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operation.setDate(LocalDate.now());
                storage.save(operation);
                return operation;
            case "/":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operation.setDate(LocalDate.now());
                storage.save(operation);
                return operation;
        }
        return null;
    }

    public List<String> getHistory() {
        List<Operation> all = storage.findAll();
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

