import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private int amount;
    private LocalDate date;

    public Transaction(int amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }
}
