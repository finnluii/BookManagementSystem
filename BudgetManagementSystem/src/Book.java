import java.sql.*;

public class Book {

    // Instances
    private String title;
    private String author;
    private double cost;

    // Constructor method
    public Book(String bookTitle, String bookAuthor, double bookPrice) {
        title = bookTitle;
        author = bookAuthor;
//        if (bookPrice < 0) {
//            throw new IllegalArgumentException("Invalid price. Must be greater than $0.");
//        } else {
//            cost = bookPrice;
//        }
        cost = bookPrice;
    }

    public String getTitle(){
        return this.title;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double newCost) {
        this.cost = newCost;
    }

}
