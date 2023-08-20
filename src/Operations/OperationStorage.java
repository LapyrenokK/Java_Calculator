package Operations;

import java.io.File;
import java.util.List;

public interface OperationStorage {
    void save(Operation operation, File file);

    List<Operation> findAll(File file);

}
