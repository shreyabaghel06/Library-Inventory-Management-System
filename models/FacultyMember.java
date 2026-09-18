package models;

public class FacultyMember extends Member {
    public FacultyMember(int memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}