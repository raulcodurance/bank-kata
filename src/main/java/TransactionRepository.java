import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {


    private List<Transaction> dataSource = new ArrayList<>();

    public void save(Transaction transaction) {

        dataSource.add(transaction);
    }

    public List<Transaction> findAll() {

        return dataSource;
    }
}
