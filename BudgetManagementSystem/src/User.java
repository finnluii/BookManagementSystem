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

    public String getLastName() {
        return this.lastName;
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

    }

    public int setUserID() {
        idNum++;
        return idNum;
    }

    public void removeBook(String title) {
        Book toDelete = null;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                toDelete = books.remove(i);
            }

        }
        if (toDelete == null) {
            System.out.println(title + " could not be found and therefore could not " +
                    "be deleted.");
        }
    }

    public void userInfo() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("The books " + getFirstName() + "'s library include: ");
        for (int i=0; i < books.size(); i++) {
            System.out.println(" - " + books.get(i).getTitle() + ", by " + books.get(i).getAuthor());
        }
    }
}
