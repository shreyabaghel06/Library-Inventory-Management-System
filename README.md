# Library Management System

A Java console-based Library Management System that manages books, library members, book issuing and returning, and transaction records.

The project demonstrates important Object-Oriented Programming concepts along with file handling, exception handling, searching, sorting, and collections in Java.

## Features

* Add and view books
* Register student and faculty members
* View registered members
* Issue books to members
* Return books
* Maintain transaction records
* Search books by Book ID
* Sort books alphabetically by title
* Save and load data using CSV files
* Custom exception handling
* Different borrowing limits for students and faculty

## Technologies Used

* **Language:** Java
* **Programming Concepts:** OOP, Encapsulation, Inheritance, Polymorphism
* **Collections:** HashMap, ArrayList
* **File Handling:** FileReader, FileWriter, BufferedReader
* **Data Storage:** CSV files
* **Exception Handling:** Custom Exceptions
* **IDE:** VS Code / IntelliJ IDEA

## Project Structure

```text
Library-Inventory-Management-System/
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
│   ├── FileManager.java
│   └── BookTitleComparator.java
│
├── data/
│   ├── books.csv
│   ├── members.csv
│   └── transactions.csv
│
├── .gitignore
└── README.md
```

## Main Menu

The application provides the following options:

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

## How to Run

### 1. Clone the Repository

Clone the GitHub repository to your computer.

### 2. Open the Project

Open the project folder in VS Code, IntelliJ IDEA, or another Java IDE.

### 3. Compile the Project

Open the terminal in the project folder and run:

```text
javac Main.java Library.java models/*.java exceptions/*.java utils/*.java
```

### 4. Run the Application

```text
java Main
```

## Data Storage

The system uses CSV files to store data:

* `books.csv` — stores book information and availability
* `members.csv` — stores member information and member type
* `transactions.csv` — stores issue and return transactions

## Exception Handling

The project uses custom exceptions to handle important situations:

* `BookNotAvailableException` — used when a book cannot be issued because it is unavailable.
* `MemberLimitExceededException` — used when a member has reached their borrowing limit.

## Searching and Sorting

The system provides:

* **Search Book:** Finds a book using its Book ID.
* **Sort Books by Title:** Arranges books alphabetically using a custom comparator.

## Testing

The following features were tested:

* Adding books
* Viewing books
* Registering members
* Viewing members
* Issuing books
* Returning books
* Viewing transactions
* Searching books
* Sorting books by title
* Saving data and exiting the application

## Future Improvements

Possible future enhancements include:

* Graphical User Interface (GUI)
* MySQL database integration
* User login and authentication
* Fine calculation for overdue books
* Advanced search and reporting
* Admin dashboard

## Author

**Shreya Baghel**

VIT Bhopal University
Computer Science Engineering (AI & ML)

