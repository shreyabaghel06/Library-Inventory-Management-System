import exceptions.BookNotAvailableException;
import exceptions.MemberLimitExceededException;
import java.util.Scanner;
import models.Book;
import models.FacultyMember;
import models.StudentMember;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while(true) {

            System.out.println("\n============================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM");
            System.out.println("============================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Transactions");
            System.out.println("8. Save & Exit");
            System.out.println("9. Search Book");
            System.out.println("10. Sort Books by Title");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book = new Book(bookId, title, author);

                    if(library.addBook(book)) {
                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Book ID already exists!");
                    }
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();

                    System.out.println("1. Student");
                    System.out.println("2. Faculty");
                    System.out.print("Select Type: ");
                    int type = sc.nextInt();

                    boolean added = false;

                    if(type == 1) {
                        added = library.addMember(new StudentMember(memberId, name));
                    } else if(type == 2) {
                        added = library.addMember(new FacultyMember(memberId, name));
                    } else {
                        System.out.println("Invalid member type!");
                        break;
                    }

                    if(added) {
                        System.out.println("Member registered successfully!");
                    } else {
                        System.out.println("Member ID already exists!");
                    }
                    break;

                case 4:
                    library.displayMembers();
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int bookToIssue = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int memberToIssue = sc.nextInt();

                    try {
                        library.issueBook(bookToIssue, memberToIssue);
                    } catch(BookNotAvailableException | MemberLimitExceededException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Enter Book ID: ");
                    int bookToReturn = sc.nextInt();

                    library.returnBook(bookToReturn);
                    break;

                case 7:
                    library.displayTransactions();
                    break;

                case 8:
                    library.saveData();
                    System.out.println("Data saved successfully!");
                    System.out.println("Thank you for using the Library Management System.");

                    sc.close();
                    return;

                case 9:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();

                    library.searchBook(searchId);
                    break;

                case 10:
                    library.sortBooksByTitle();
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}