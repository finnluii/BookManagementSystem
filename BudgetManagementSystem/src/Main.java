import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Scanner;

public class Main {

    public static void main (String args[ ]) {
//        Book book = new Book("Harry Potter", "JK Rowling", 29.99);

        Scanner scanner = new Scanner(System.in);

        /* Title */
        System.out.println("Tell me about the book you bought today. What's the name?");
//        String title = scanner.nextLine().replaceAll("\\s+","");
        String title = scanner.nextLine().trim();
        while (title.isEmpty()) {
            System.out.println("You must enter a title!");
            title = scanner.nextLine().replaceAll("\\s+","");
        }

        /* Author */
        System.out.println("Who's the author(s)?");
        String author = scanner.nextLine().replaceAll("\\s+","");
        while (author.isEmpty()) {
            System.out.println("You must enter at least one author!");
            author = scanner.nextLine().replaceAll("\\s+","");
        }

        /* Cost */
        System.out.println("How much did it cost?");
        double cost = scanner.nextDouble();
        System.out.print(cost);

        System.out.println(title);
        System.out.println(author);
        Book book = new Book(title, author, cost);

        // Database connection
        /*
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        */


    }
}
