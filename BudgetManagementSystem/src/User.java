import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class User {

    // Instances
//    private String firstName;
//    private String lastName;
    private String userName;
    private int userID;
    private static int idNum = 0;
//    private List<Book> books = new ArrayList<Book>();


    // Constructor
    public User() {
//        this.firstName = setFirstName();
//        this.lastName = setLastName();
        this.userName = setUserName();
        this.userID = setUserID();
//        System.out.println(books);
    }
//    public String getFirstName() {
//        return this.firstName;
//    }
//    public String setFirstName() {
//        System.out.print("Enter your name:");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine().trim();
//        while (name.isEmpty()) {
//            System.out.print("Hmm, I don't see anything. Please try again: ");
//            name = scanner.nextLine().trim();
//        }
//        return name;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }
//
//    public String setLastName() {
//        System.out.print("Enter your last name:");
//        Scanner scanner = new Scanner(System.in);
//        String lastName = scanner.nextLine().trim();
//        while (lastName.isEmpty()) {
//            System.out.print("Hmm, I don't see anything. Please try again: ");
//            lastName = scanner.nextLine().trim();
//        }
//        return lastName;
//    }

    public String getUserName() {
        return this.userName;
    }
    public String setUserName() {
        System.out.print("Enter your username:");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine().trim();
        while (userName.isEmpty()) {
            System.out.print("Hmm, I don't see anything. Please try again: ");
            userName = scanner.nextLine().trim();
        }
        return userName;
    }

    public int setUserID() {
        idNum++;
        return idNum;
    }

    public void addBook(Book book) {
//        this.books.add(book);
        SQLiteConnection.insert(book.getISBN(), book.getTitle(), book.getAuthor(), book.getCost());

    }

    public void update(String column, String newValue) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the column you want to edit?");

        System.out.println("What is the value you want updated?");

        System.out.println("What is the ISBN of the book you want to update?");

        String isbn = scanner.nextLine().trim();
        while (isbn.isEmpty()) {
            System.out.print("Hmm, I don't see anything. Please try again: ");
            isbn = scanner.nextLine().trim();
        }
        SQLiteConnection.update(isbn, column, newValue);
    }

    public void deleteBook(String isbn) {
        SQLiteConnection.delete(isbn);

//        Book toDelete = null;
//        for (int i = 0; i < books.size(); i++) {
//            if (books.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) {
//                toDelete = books.remove(i);
//            }
//
//        }
//        if (toDelete == null) {
//            System.out.println(title + " could not be found and therefore could not " +
//                    "be deleted.");
//        }
    }

    public void userInfo() {
        System.out.println("Username: " + getUserName());
        System.out.println("The books " + getUserName() + "'s library include: ");

        //TODO
//        for (int i=0; i < books.size(); i++) {
//            System.out.println(" - " + books.get(i).getTitle() + ", by " + books.get(i).getAuthor());
//        }
    }
}
