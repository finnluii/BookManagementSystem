import java.util.Scanner;
import java.util.ArrayList;
public class User {

    // Instances
    private String firstName;
    private String lastName;
    private int userID;
    private static int idNum = 0;
    private ArrayList<Book> books = new ArrayList<Book>();


    // Constructor
    public User() {
        this.firstName = setFirstName();
        this.lastName = setLastName();
        this.userID = setUserID();
        System.out.println(books);
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String setFirstName() {
        System.out.print("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Hmm, I don't see anything. Please try again: ");
            name = scanner.nextLine().trim();
        }
        return name;
    }

    public String setLastName() {
        System.out.print("Enter your last name:");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine().trim();
        while (lastName.isEmpty()) {
            System.out.print("Hmm, I don't see anything. Please try again: ");
            lastName = scanner.nextLine().trim();
        }
        return lastName;
    }

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("After adding the new book: ");

        for (int i=0; i < books.size(); i++) {
            System.out.println("Book: " + books.get(i).getTitle());
        }
    }

    public int setUserID() {
        idNum++;
        return idNum;
    }
}
