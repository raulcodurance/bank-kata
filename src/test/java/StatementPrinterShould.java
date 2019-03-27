import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {


    private StatementPrinter statementPrinter;
    @Mock CustomConsole console;

    @Before
    public void setUp() {
        this.statementPrinter = new StatementPrinter(console);
    }


    @Test
    public void
    print_headers() {

        statementPrinter.print(Collections.emptyList());
        verify(console).print("DATE | AMOUNT  | BALANCE");
    }


    /*@Test
    public void
    print_transactions_in_reversed_chronological_order() {
        statementPrinter.print(asList(
                new Transaction(1000, LocalDate.of(2014, 4, 1)),
                new Transaction(-100, LocalDate.of(2014, 4, 2)),
                new Transaction(500, LocalDate.of(2014, 4, 10))
        ));

        verify(console).print("DATE | AMOUNT  | BALANCE");
        verify(console).print("10/04/2014 | 500.00  | 1400.00");
        verify(console).print("02/04/2014 | -100.00 | 900.00");
        verify(console).print("01/04/2014 | 1000.00 | 1000.00");
    }*/
}
