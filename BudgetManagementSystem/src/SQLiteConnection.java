import com.sun.istack.internal.NotNull;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;

public class SQLiteConnection {
    private static Connection singleConnection;
    public static Connection connectDB() {
//        Connection c = singleConnection;
//        try {
//            System.out.println("Entered try block in SQLiteConnection");
//            Class.forName("org.sqlite.JDBC");
//            if (c == null) {
//                System.out.println("Connection was null. Entered here.");
//                c = DriverManager.getConnection("jdbc:sqlite:books.db");
//                singleConnection = c;
//            }
//            return c;
        try {
            System.out.println("Entered try block in SQLiteConnection");
            Class.forName("org.sqlite.JDBC");
            if (singleConnection == null) {
                System.out.println("Connection was null. Entered here.");
                singleConnection = DriverManager.getConnection("jdbc:sqlite:books.db");
            }
            return singleConnection;

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
                    "ISBN TEXT PRIMARY KEY, " +
                    "TITLE TEXT NOT NULL, " +
                    "AUTHOR TEXT, " +
                    "COST INTEGER " +
                    ")";
            stmt.executeUpdate((sql_create_table));
            stmt.close();


        } catch (SQLException e) {
            System.out.println("Table BOOKS already exists.");
        }
    }

    public static void insert(String bookID, String title, String author, double cost) {
        try {
            String insert_stmt = "INSERT INTO BOOKS(ISBN, title, author, cost) VALUES (?,?,?,?)";
            PreparedStatement pstmt = singleConnection.prepareStatement(insert_stmt);
            pstmt.setString(1, bookID.toString());
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setInt(4, (int) (cost * 100));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error in INSERT query.");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public static void select() {
        try {
            String select_stmt = "SELECT * FROM BOOKS";
            Statement stmt = singleConnection.createStatement();
            ResultSet rs = stmt.executeQuery(select_stmt);

            while (rs.next()) {
                System.out.println(rs.getString("TITLE"));
            }
        } catch (SQLException e) {
            System.out.println("Error in SELECT query.");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public static void delete(String isbn) {
        try {
            String select_stmt = "DELETE FROM BOOKS WHERE ISBN = ?";
            PreparedStatement pstmt = singleConnection.prepareStatement(select_stmt);
            pstmt.setString(1, isbn);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error in DELETE query.");
            System.out.println(e.getMessage());
            System.exit(-1);

        }
    }
    public static void closeDBConnection() {
        try {
            singleConnection.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection.");
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