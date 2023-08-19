package OperationStorages;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperationStorage implements OperationStorage {
    private  File file = new File("res/CalcHistory.txt");


    @Override
    public void save(Operation operation) {
        try (FileWriter wf = new FileWriter(file, true)) {
            wf.write(operation.getNum1()
                    + " " + operation.getType()
                    + " " + operation.getNum2()
                    + " " + operation.getResult()
                    + " " + operation.getDate()
                    + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAll() {
        List<Operation> operations = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] stringForOptions = sc.nextLine().split(" ");
                Operation operationConverted =
                        new Operation(Double.parseDouble(stringForOptions[0]),
                                      stringForOptions[1],
                                      Double.parseDouble(stringForOptions[2]),
                                      Double.parseDouble(stringForOptions[3]),
                                      LocalDate.parse(stringForOptions[4]));
                operations.add(operationConverted);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operations;
    }
}
