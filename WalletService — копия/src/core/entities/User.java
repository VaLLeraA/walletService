package entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private long balance;
    private List<Transaction> transactionsHistory;
    private List<ActionOfUser> userActions;
    private boolean isRegistered = false;
    public User(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

    public void setTransactionsHistory(List<Transaction> transactionsHistory) {
        this.transactionsHistory = transactionsHistory;
    }

    public List<ActionOfUser> getUserActions() {
        return userActions;
    }

    public void setUserActions(List<ActionOfUser> userActions) {
        this.userActions = userActions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User {");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", transactionsHistory=").append(transactionsHistory);
        sb.append(", userActions=").append(userActions);
        sb.append('}');
        return sb.toString();
    }
}
