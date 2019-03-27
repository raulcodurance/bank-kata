import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintStatementFeature {

    @Test
    public void
    prints_all_transactions_in_reverse_chronological_order() {

        CustomConsole console = mock(CustomConsole.class);
        CustomTime time = mock(CustomTime.class);

        StatementPrinter statementPrinter = new StatementPrinter(console);
        TransactionRepository transactionRepository = new TransactionRepository();
        AccountService accountService = new AccountService(transactionRepository, time, statementPrinter);

        accountService.deposit(1000);
        accountService.withdraw(100);
        accountService.deposit(500);
        accountService.printStatement();

        verify(console).print("DATE | AMOUNT  | BALANCE");
        verify(console).print("10/04/2014 | 500.00  | 1400.00");
        verify(console).print("02/04/2014 | -100.00 | 900.00");
        verify(console).print("01/04/2014 | 1000.00 | 1000.00");
    }
}
