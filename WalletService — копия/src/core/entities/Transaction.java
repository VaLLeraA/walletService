package entities;

public class Transaction {

    private long id;
    private String transactionType;

    public Transaction(long id, String transactionType) {
        this.id = id;
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction {");
        sb.append("id=").append(id);
        sb.append(", transactionType='").append(transactionType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
