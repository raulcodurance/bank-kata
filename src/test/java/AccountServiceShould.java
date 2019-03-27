import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountServiceShould {

    private LocalDate currentDate;
    private CustomTime time;
    private TransactionRepository transactionRepository;
    private AccountService accountService;
    private StatementPrinter statementPrinter;

    @Before
    public void setUp() throws Exception {

        currentDate = LocalDate.of(2018, 1, 1);
        time = mock(CustomTime.class);
        transactionRepository = mock(TransactionRepository.class);
        statementPrinter = mock(StatementPrinter.class);
        accountService = new AccountService(transactionRepository, time, statementPrinter);
    }

    @Test
    public void
    store_deposit_transactions() {

        given(time.currentDate()).willReturn(currentDate);

        accountService.deposit(1000);

        verify(transactionRepository).save(new Transaction(1000, currentDate));
    }

    @Test
    public void
    store_withdraw_transactions() {

        given(time.currentDate()).willReturn(currentDate);

        accountService.withdraw(100);

        verify(transactionRepository).save(new Transaction(-100, currentDate));
    }

    @Test
    public void
    print_formatted_transactions() {

        given(transactionRepository.findAll()).willReturn(Collections.singletonList(new Transaction(1000, currentDate)));

        accountService.printStatement();

        verify(statementPrinter).print(transactionRepository.findAll());
    }
}
