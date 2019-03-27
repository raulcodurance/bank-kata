public class AccountService {
    private TransactionRepository transactionRepository;
    private CustomTime time;
    private StatementPrinter statementPrinter;

    public AccountService(TransactionRepository transactionRepository, CustomTime time, StatementPrinter statementPrinter) {

        this.transactionRepository = transactionRepository;
        this.time = time;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {

        transactionRepository.save(new Transaction(amount, time.currentDate()));
    }

    public void withdraw(int amount) {

        transactionRepository.save(new Transaction(-amount,time.currentDate()));
    }

    public void printStatement() {

        statementPrinter.print(transactionRepository.findAll());
    }
}
