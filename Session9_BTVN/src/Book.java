public class Book {
    private String title;
    private String author;
    private double price;

    // Constructor (khuyến khích)
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // In thông tin
    public void printInfo() {
        System.out.println("Title: " + title +
                ", Author: " + author +
                ", Price: " + price);
    }
}