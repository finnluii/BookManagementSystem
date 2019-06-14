import java.sql.Connection;
import java.sql.DriverManager;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main (String args[ ]) {

        Scanner scanner = new Scanner(System.in);

        boolean exit = true;
        int input_num;
        System.out.println("Input 'add' if you would like a new book that you read.");
        System.out.println("Input 'update' if you would like to update an existing book you've read.");
        System.out.println("Input 'display' to see all books saved.");
        System.out.println("Input 'delete' to delete a book.");
        System.out.println("Input 'exit' if you would like to exit the application.");

        while (exit){

            String input = scanner.nextLine().trim();
            exit = false;

            switch (input) {
                case "add":
                    /* Title */
                    System.out.println("Great. What book do you want to add to your collection?");
                    String title = scanner.nextLine().trim();
                    while (title.isEmpty()) {
                        System.out.println("You must enter a title!");
                        title = scanner.nextLine().trim();
                    }

//                    /* Author */
//                    System.out.println("Who's the author(s)?");
//                    String author = scanner.nextLine().trim();
//                    while (author.isEmpty()) {
//                        System.out.println("You must enter at least one author!");
//                        author = scanner.nextLine().trim();
//                    }
//
//                    /* Cost */
//                    double cost = 0;
//                    while (true) {
//                        try {
//                            System.out.println("How much did it cost?");
//                            scanner = new Scanner(System.in);
//                            cost = scanner.nextDouble();
//                            break;
//                        } catch (InputMismatchException e) {
//                            System.out.println("Please enter a number!");
//                        }
//                    }
//
//                    System.out.println(cost);
//
//                    System.out.println(title);
//                    System.out.println(author);
//                    Book book = new Book(title, author, cost);
                    Book book = new Book(title);

                    input_num = 0;
                    break;
                case "update":
                    input_num = 1;
                    break;
                case "display":
                    input_num = 2;
                    break;
                case "delete":
                    input_num = 3;
                    break;
                case "exit":
                    input_num = 4;
                    break;
                default:
                    exit = true;
                    System.out.println("Invalid option. Please try again!");
                    break;

            }
        }

        System.exit(-1);






//        // Database connection
//        Connection c = null;
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:books.db");
//
//
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(1);
//        }
//
//        // Successfully opened database
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
//
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
