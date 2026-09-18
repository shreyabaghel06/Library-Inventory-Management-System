package utils;
import java.io.*;
import java.util.*;
import models.*;
public class FileManager {

    public static void saveBooks(HashMap<Integer, Book> books) {

        try {
            FileWriter fw = new FileWriter("data/books.csv");

            for (Book b : books.values()) {
                fw.write(b.getBookId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.isAvailable() + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    public static HashMap<Integer, Book> loadBooks() {
        HashMap<Integer, Book> books = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/books.csv"));

            String line;

            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book(
                    Integer.parseInt(data[0].trim()),
                    data[1].trim(),
                    data[2].trim()
                );
                book.setAvailable(Boolean.parseBoolean(data[3].trim()));
                
                books.put(book.getBookId(),book);
            }

            br.close();

        } catch (IOException e) {

        }
        return books;
    }

    public static void saveMembers(HashMap<Integer, Member> members) {

        try {
            FileWriter fw = new FileWriter("data/members.csv");

            for (Member m : members.values()) {
                String type;

                if (m instanceof StudentMember) {
                    type = "STUDENT";
                } else {
                    type = "FACULTY";
                }

                fw.write( m.getMemberId() + "," + m.getName() + "," + type + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Error saving members.");
        }
    }

    public static HashMap<Integer, Member> loadMembers() {

        HashMap<Integer, Member> members = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/members.csv"));

            String line;

            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int memberId = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String type = data[2].trim();

                Member member;

                if(type.equals("STUDENT")) {
                    member = new StudentMember(memberId,name);
                } else {
                    member = new FacultyMember(memberId,name);
                }
                members.put(memberId,member);
            }

            br.close();

        } catch (IOException e) {

        }
        return members;
    }

    public static void saveTransactions(ArrayList<Transaction> transactions) {

        try {
            FileWriter fw = new FileWriter("data/transactions.csv");

            for(Transaction t : transactions) {
                fw.write(t.getTransactionId() + "," + t.getBookId() + "," + t.getMemberId() + "," + t.getType() + "\n");
            }

            fw.close();

        } catch(IOException e) {
            System.out.println("Error saving transactions.");
        }
    }

    public static ArrayList<Transaction> loadTransactions() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/transactions.csv"));

            String line;

            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Transaction transaction = new Transaction(
                    Integer.parseInt(data[0].trim()),
                    Integer.parseInt(data[1].trim()),
                    Integer.parseInt(data[2].trim()),
                    data[3].trim()
                );
                transactions.add(transaction);
            }

            br.close();

        } catch(IOException e) {

        }

        return transactions;
    }
}
