import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TransactionRepositoryShould {


    @Test
    public void
    save_transaction() {

        LocalDate currentDate = LocalDate.of(2018, 1, 1);

        TransactionRepository transactionRepository = new TransactionRepository();
        Transaction transaction = new Transaction(1000, currentDate);

        transactionRepository.save(transaction);

        assertThat(transactionRepository.findAll().size(), is(1));
        assertThat(transactionRepository.findAll().get(0), is(new Transaction(1000, currentDate)));
    }
}
