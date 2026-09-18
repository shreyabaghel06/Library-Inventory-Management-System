package models;

public abstract class Member {
    private int memberId;
    private String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
  
    public abstract int getBorrowLimit();

    public void displayMember() {
        System.out.println("---------------------------");
        System.out.println("Member ID: " + memberId);
        System.out.println("Name : " + name);
        System.out.println("Borrow Limit: " + getBorrowLimit());
    }
}