import java.sql.Connection;
import java.sql.DriverManager;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main (String args[]) {

//        // Database connection
//        Connection c = null;
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:books.db");
//
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(1);
//        }
//
//        // Create BOOKS table if not already exists
//        try {
//            Statement stmt = c.createStatement();
//            String sql_create_table = "CREATE TABLE BOOKS(" +
//                    "ISBN INT PRIMARY KEY NOT NULL, " +
//                    "TITLE TEXT NOT NULL, " +
//                    "AUTHOR TEXT" +
//                    ")";
//            stmt.executeUpdate((sql_create_table));
//            stmt.close();
//            c.close();
//
//        } catch (SQLException e) {
//            System.out.println("Table BOOKS already exists.");
//        }

        SQLiteConnection.connectDB();
        SQLiteConnection.createDB();
        User user1 = new User();
        System.out.println("Welcome, " + user1.getUserName());
        Scanner scanner = new Scanner(System.in);

        boolean exit = true;
        int input_num;

        System.out.println("Input 'add' if you would like a new book that you read.");
        System.out.println("Input 'update' if you would like to update an existing book you've read.");
        System.out.println("Input 'display' to see all books saved.");
        System.out.println("Input 'delete' to delete a book.");
        System.out.println("Input 'exit' if you would like to exit the application.");

        while (exit) {
            System.out.println("Enter input: ");

            String input = scanner.nextLine().trim();
//            exit = false;

            switch (input) {
                case "add":
                    Book newBook = new Book();
                    user1.addBook(newBook);
                    break;
                case "update":
                    user1.update("ISBN", "1.99");
                    break;
                case "display":
                    user1.userInfo();
                    SQLiteConnection.select();
                    break;
                case "delete":
                    System.out.println("What is the ISBN of the book you want to remove?");
                    String isbn = scanner.nextLine().trim();

                    user1.deleteBook(isbn);
                    user1.userInfo();
                    break;
                case "exit":
                    exit = false;
                    break;
                default:
                    exit = true;
                    System.out.println("Invalid option. Please try again!");
                    break;

            }
        }

        SQLiteConnection.closeDBConnection();
        System.exit(-1);






//        try {
//            Statement stmt = c.createStatement();
//            String sql_insert_book = "SELECT COUNT(*) FROM BOOKS WHERE TITLE='harry' AND AUTHOR='rowling'";
//
//            stmt.executeUpdate(sql_insert_book);
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            System.exit(-1);
//        }

    }
}
