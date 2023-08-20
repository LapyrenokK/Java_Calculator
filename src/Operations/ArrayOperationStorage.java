package Operations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArrayOperationStorage implements OperationStorage {

    private final List<Operation> operations = new ArrayList<>();

    @Override
    public void save(Operation operation,File file) {
    operations.add(operation);
    }

    @Override
    public List<Operation> findAll(File file) {
        return new ArrayList<>(this.operations);
    }

}
