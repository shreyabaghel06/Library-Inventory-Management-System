import exceptions.BookNotAvailableException;
import exceptions.MemberLimitExceededException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import models.Book;
import models.Member;
import models.Transaction;
import utils.FileManager;

public class Library {

    private HashMap<Integer, Book> books;
    private HashMap<Integer, Member> members;
    private ArrayList<Transaction> transactions;

    public Library() {

        // Load saved data from CSV files
        books = FileManager.loadBooks();

        members = FileManager.loadMembers();

        transactions = FileManager.loadTransactions();
    }

    // =========================
    // ADD BOOK
    // =========================
    public boolean addBook(Book book) {

        if (books.containsKey(book.getBookId())) {

            return false;
        }

        books.put(
                book.getBookId(),
                book
        );

        return true;
    }

    // =========================
    // ADD MEMBER
    // =========================
    public boolean addMember(Member member) {

        if (members.containsKey(member.getMemberId())) {

            return false;
        }

        members.put(
                member.getMemberId(),
                member
        );

        return true;
    }

    // =========================
    // COUNT BORROWED BOOKS
    // =========================
    private int countBorrowedBooks(int memberId) {

        int count = 0;

        for (Transaction t : transactions) {

            if (t.getMemberId() == memberId &&
                    t.getType().equals("ISSUE")) {

                count++;
            }

            if (t.getMemberId() == memberId &&
                    t.getType().equals("RETURN")) {

                count--;
            }
        }

        return count;
    }

    // =========================
    // ISSUE BOOK
    // =========================
    public void issueBook(
            int bookId,
            int memberId
    )
            throws BookNotAvailableException,
            MemberLimitExceededException {

        Book book = books.get(bookId);

        Member member = members.get(memberId);

        if (book == null) {

            throw new BookNotAvailableException(
                    "Book not found."
            );
        }

        if (member == null) {

            throw new MemberLimitExceededException(
                    "Member not found."
            );
        }

        if (!book.isAvailable()) {

            throw new BookNotAvailableException(
                    "Book already issued."
            );
        }

        if (countBorrowedBooks(memberId)
                >= member.getBorrowLimit()) {

            throw new MemberLimitExceededException(
                    "Borrow limit exceeded."
            );
        }

        book.setAvailable(false);

        transactions.add(
                new Transaction(
                        1000 + transactions.size() + 1,
                        bookId,
                        memberId,
                        "ISSUE"
                )
        );

        System.out.println(
                "Book issued successfully!"
        );
    }

    // =========================
    // RETURN BOOK
    // =========================
    public void returnBook(int bookId) {

        Book book = books.get(bookId);

        if (book == null) {

            System.out.println(
                    "Book not found."
            );

            return;
        }

        if (book.isAvailable()) {

            System.out.println(
                    "Book already available."
            );

            return;
        }

        int memberId = 0;

        for (
                int i = transactions.size() - 1;
                i >= 0;
                i--
        ) {

            Transaction t =
                    transactions.get(i);

            if (
                    t.getBookId() == bookId &&
                    t.getType().equals("ISSUE")
            ) {

                memberId =
                        t.getMemberId();

                break;
            }
        }

        book.setAvailable(true);

        transactions.add(
                new Transaction(
                        1000 + transactions.size() + 1,
                        bookId,
                        memberId,
                        "RETURN"
                )
        );

        System.out.println(
                "Book returned successfully!"
        );
    }

    // =========================
    // DISPLAY BOOKS
    // =========================
    public void displayBooks() {

        System.out.println(
                "\n===== BOOKS ====="
        );

        for (Book b : books.values()) {

            b.displayBook();
        }
    }

    // =========================
    // DISPLAY MEMBERS
    // =========================
    public void displayMembers() {

        System.out.println(
                "\n===== MEMBERS ====="
        );

        for (Member m : members.values()) {

            m.displayMember();
        }
    }

    // =========================
    // DISPLAY TRANSACTIONS
    // =========================
    public void displayTransactions() {

        System.out.println(
                "\n===== TRANSACTIONS ====="
        );

        for (Transaction t : transactions) {

            t.displayTransaction();
        }
    }

    // =========================
    // SEARCH BOOK
    // =========================
    public void searchBook(int bookId) {

        Book book = books.get(bookId);

        if (book == null) {

            System.out.println(
                    "Book not found!"
            );

        } else {

            System.out.println(
                    "\n===== BOOK FOUND ====="
            );

            book.displayBook();
        }
    }

    // =========================
    // SORT BOOKS BY TITLE
    // =========================
    public void sortBooksByTitle() {

        ArrayList<Book> sortedBooks =
                new ArrayList<>(
                        books.values()
                );

        sortedBooks.sort(
                Comparator.comparing(
                        Book::getTitle
                )
        );

        System.out.println(
                "\n===== BOOKS SORTED BY TITLE ====="
        );

        for (Book b : sortedBooks) {

            b.displayBook();
        }
    }

    // =========================
    // SAVE ALL DATA
    // =========================
    public void saveData() {

        FileManager.saveBooks(books);

        FileManager.saveMembers(members);

        FileManager.saveTransactions(
                transactions
        );
    }

    // =========================
    // GET BOOKS
    // =========================
    public HashMap<Integer, Book> getBooks() {

        return books;
    }
}