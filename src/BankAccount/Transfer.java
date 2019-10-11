package BankAccount;

import java.util.Arrays;

public class Transfer {
    private Float amount;
    private String[] date;
    private String title;
    private String type;

    //chcialbym wprowadzic tu typ Date i Enum typ transakcji
    public Transfer(Float amount, String[] date, String title, String type) {
        this.amount = amount;
        this.date = date;
        this.title = title;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "amount=" + amount +
                ", date=" + Arrays.toString(date) +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
