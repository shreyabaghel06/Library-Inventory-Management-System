package models;

public class StudentMember extends Member {

    public StudentMember(int memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getBorrowLimit() {
        return 3;
    }
}