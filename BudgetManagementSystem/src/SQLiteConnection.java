import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {
    private static Connection singleConnection;
    public static Connection connectDB() {
        Connection c = singleConnection;
        try {
            System.out.println("Entered try block in SQLiteConnection");
            Class.forName("org.sqlite.JDBC");
            if (c == null) {
                System.out.println("Connection was null. Entered here.");
                c = DriverManager.getConnection("jdbc:sqlite:books.db");
                singleConnection = c;
            }
            return c;

        } catch ( Exception e ) {
            System.out.println("Entered catch block in SQLiteConnection");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(1);

        }
        return null;

    }

    /*
    Establish a connection using connectDB() before calling this method
     */
    public static void createDB() {
//         Successfully opened database
        try {
            Statement stmt = singleConnection.createStatement();
            String sql_create_table = "CREATE TABLE BOOKS(" +
                    "TITLE TEXT NOT NULL, " +
                    "AUTHOR TEXT" +
                    "COST INTEGER" +
                    ")";
            stmt.executeUpdate((sql_create_table));
            stmt.close();
            singleConnection.close();

        } catch (SQLException e) {
            System.out.println("Table BOOKS already exists.");
        }
    }

    public static void insert(String title, String author, double cost) {
        try {
            Statement stmt = singleConnection.createStatement();
//            String sql_insert_book = "SELECT COUNT(*) FROM BOOKS WHERE TITLE='harry' AND AUTHOR='rowling'";

            String insert_stmt = "INSERT INTO BOOKS(title, author, cost) VALUES (?,?,?)";
            stmt.executeUpdate(insert_stmt);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

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