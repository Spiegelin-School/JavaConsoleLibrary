/**
 * The Book class represents a book in the library
 * It holds the book's title, author, ISBN, and the number of copies available
 */
public class Book {
    // Book details
    private String title;
    private String author;
    private String isbn;
    private int totalCopies;
    private int availableCopies;

    /**
     * Constructor to initialize a Book object with title, author, ISBN, and copies.
     * Initially, the available copies are the same as the total copies.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @param isbn   The ISBN of the book.
     * @param copies The total number of copies of the book.
     */
    public Book(String title, String author, String isbn, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Reduces the available copies by one if there are copies available.
     */
    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    /**
     * Increases the available copies by one if not all copies are already in the library.
     */
    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    /**
     * Returns a string representation of the book details.
     */
    @Override
    public String toString() {
        return "Title: " + title + 
               ", Author: " + author + 
               ", ISBN: " + isbn + 
               ", Copies Available: " + availableCopies;
    }
}
