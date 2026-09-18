package models;

public class Transaction {

    private int transactionId;
    private int bookId;
    private int memberId;
    private String type;

    public Transaction(int transactionId, int bookId, int memberId, String type) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.type = type;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public void displayTransaction() {
        System.out.println("---------------------------");
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Book ID : " + bookId);
        System.out.println("Member ID : " + memberId);
        System.out.println("Type : " + type);
    }
}