import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of books and patrons
 * It has to add, remove, display, borrow, and return books
 * also to register and display patrons
 */
public class Library {
    // List to store Book objects
    private List<Book> books;
    // List to store Patron objects
    private List<Patron> patrons;

    /**
     * Constructor initializes the lists for books and patrons.
     */
    public Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    /**
     * Adds a new book to the library.
     *
     * @param book The Book object to be added.
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    /**
     * Removes a book from the library using its ISBN.
     *
     * @param isbn The ISBN of the book to be removed.
     */
    public void removeBook(String isbn) {
        Book bookToRemove = null;
        // Find the book with the given ISBN
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                bookToRemove = b;
                break;
            }
        }
        // If the book is found, remove it
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    /**
     * Displays all books in the library.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    /**
     * Registers a new patron in the library.
     *
     * @param patron The Patron object to be registered.
     */
    public void registerPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron registered successfully.");
    }

    /**
     * Displays all registered patrons.
     */
    public void displayPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons registered.");
        } else {
            for (Patron p : patrons) {
                System.out.println(p);
            }
        }
    }

    /**
     * Allows a patron to borrow a book by providing its ISBN.
     * It decreases the available copy count if the book exists and copies are available.
     *
     * @param isbn The ISBN of the book to borrow.
     */
    public void borrowBook(String isbn) {
        Book bookToBorrow = null;
        // Find the book by ISBN
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                bookToBorrow = b;
                break;
            }
        }
        if (bookToBorrow != null) {
            // Check if there is an available copy
            if (bookToBorrow.getAvailableCopies() > 0) {
                bookToBorrow.borrowBook();
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("No available copies to borrow.");
            }
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    /**
     * Allows a patron to return a borrowed book by providing its ISBN.
     * It increases the available copy count if the book exists.
     *
     * @param isbn The ISBN of the book to return.
     */
    public void returnBook(String isbn) {
        Book bookToReturn = null;
        // Find the book by ISBN
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                bookToReturn = b;
                break;
            }
        }
        if (bookToReturn != null) {
            // Check if the library can accept the returned copy
            if (bookToReturn.getAvailableCopies() < bookToReturn.getTotalCopies()) {
                bookToReturn.returnBook();
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("All copies are already in the library.");
            }
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    /**
     * Searches and displays books whose titles contain the given search term.
     *
     * @param title The search term for the book title.
     */
    public void searchBooksByTitle(String title) {
        boolean found = false;
        // Iterate through the list of books and check the title
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with title containing \"" + title + "\".");
        }
    }

    /**
     * Searches and displays books by a given author.
     *
     * @param author The author name to search for.
     */
    public void searchBooksByAuthor(String author) {
        boolean found = false;
        // Iterate through the list of books and check the author
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author \"" + author + "\".");
        }
    }

    /**
     * Searches and displays a book with the given ISBN.
     *
     * @param isbn The ISBN of the book to search for.
     */
    public void searchBooksByISBN(String isbn) {
        boolean found = false;
        // Iterate through the list of books and check for matching ISBN
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                System.out.println(b);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No book found with ISBN " + isbn + ".");
        }
    }
}
