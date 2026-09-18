# Library-Inventory-Management-System

# LIBRARY-MANAGEMENT-SYSTEM

A Java console-based application that manages books, library members, book issuing/returning, and transaction records. The project demonstrates Object-Oriented Programming (OOP), inheritance, exception handling, collections, file handling, searching, and sorting.

## Features

* Add and view books
* Register student and faculty members
* View member details and borrowing limits
* Issue and return books
* Maintain transaction history
* Search books by Book ID
* Sort books alphabetically by title
* Save data using CSV files
* Custom exception handling

## Technologies Used

* **Language:** Java
* **Concepts:** OOP, Inheritance, Encapsulation, Exception Handling
* **Collections:** HashMap, ArrayList
* **File Handling:** CSV (FileReader, FileWriter, BufferedReader)
* **IDE:** VS Code / IntelliJ IDEA

## Project Structure

```text
Library-Management-System/
│
├── Main.java
├── Library.java
│
├── models/
│   ├── Book.java
│   ├── Member.java
│   ├── StudentMember.java
│   ├── FacultyMember.java
│   └── Transaction.java
│
├── exceptions/
│   ├── BookNotAvailableException.java
│   └── MemberLimitExceededException.java
│
├── utils/
│   └── FileManager.java
│
├── data/
│   ├── books.csv
│   ├── members.csv
│   └── transactions.csv
│
└── README.md
```

## How to Run

1. Clone or download the repository.
2. Open the project in VS Code or IntelliJ IDEA.
3. Compile all Java files:

```bash
javac Main.java Library.java models/*.java exceptions/*.java utils/*.java
```

4. Run the project:

```bash
java Main
```

## Testing

Test the following features from the main menu:

1. Add Book
2. View Books
3. Register Member
4. View Members
5. Issue Book
6. Return Book
7. View Transactions
8. Search Book
9. Sort Books by Title
10. Save & Exit

## Sample Output

```text
============================
 LIBRARY MANAGEMENT SYSTEM
============================
1. Add Book
2. View Books
3. Register Member
4. View Members
5. Issue Book
6. Return Book
7. View Transactions
8. Save & Exit
9. Search Book
10. Sort Books by Title
```

## Future Improvements

* Graphical User Interface (GUI)
* Database integration (MySQL)
* Login and authentication
* Fine calculation for overdue books
* Advanced reporting and analytics

## Author

**Shreya Baghel**

Registration no. - 25BAI11008

VIT Bhopal University
