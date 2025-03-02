import java.util.Scanner;

/**
 * UI for the Library Management System
 */
public class Main {
    // ANSI escape codes for colors
    // Obtained from https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";

    public static void main(String[] args) {
        // Create a new Library instance for managing books and patrons
        Library library = new Library();
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean exitMain = false;

        // Main menu loop
        while (!exitMain) {
            // Display main menu header
            System.out.println(ANSI_CYAN + "=======================================");
            System.out.println("       Library Management System       ");
            System.out.println("=======================================" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1. Book Management");
            System.out.println("2. Patron Management");
            System.out.println("3. Search");
            System.out.println("4. Exit" + ANSI_RESET);
            System.out.print(ANSI_PURPLE + "Select an option: " + ANSI_RESET);

            int mainOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (mainOption) {
                case 1:
                    // Book Management submenu loop
                    boolean backBook = false;
                    while (!backBook) {
                        System.out.println(ANSI_CYAN + "\n--- Book Management ---" + ANSI_RESET);
                        System.out.println(ANSI_YELLOW + "1. Add Book");
                        System.out.println("2. Remove Book");
                        System.out.println("3. Display Books");
                        System.out.println("4. Borrow Book");
                        System.out.println("5. Return Book");
                        System.out.println("6. Back to Main Menu" + ANSI_RESET);
                        System.out.print(ANSI_PURPLE + "Select an option: " + ANSI_RESET);

                        int bookOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (bookOption) {
                            case 1:
                                // Add a new book
                                System.out.print(ANSI_GREEN + "Enter book title: " + ANSI_RESET);
                                String title = scanner.nextLine();
                                System.out.print(ANSI_GREEN + "Enter book author: " + ANSI_RESET);
                                String author = scanner.nextLine();
                                System.out.print(ANSI_GREEN + "Enter book ISBN: " + ANSI_RESET);
                                String isbn = scanner.nextLine();
                                System.out.print(ANSI_GREEN + "Enter number of copies: " + ANSI_RESET);
                                int copies = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                Book newBook = new Book(title, author, isbn, copies);
                                library.addBook(newBook);
                                break;
                            case 2:
                                // Remove a book by ISBN
                                System.out.print(ANSI_GREEN + "Enter ISBN of book to remove: " + ANSI_RESET);
                                String removeIsbn = scanner.nextLine();
                                library.removeBook(removeIsbn);
                                break;
                            case 3:
                                // Display all books
                                library.displayBooks();
                                break;
                            case 4:
                                // Borrow a book by ISBN
                                System.out.print(ANSI_GREEN + "Enter ISBN of book to borrow: " + ANSI_RESET);
                                String borrowIsbn = scanner.nextLine();
                                library.borrowBook(borrowIsbn);
                                break;
                            case 5:
                                // Return a book by ISBN
                                System.out.print(ANSI_GREEN + "Enter ISBN of book to return: " + ANSI_RESET);
                                String returnIsbn = scanner.nextLine();
                                library.returnBook(returnIsbn);
                                break;
                            case 6:
                                // Return to main menu
                                backBook = true;
                                break;
                            default:
                                System.out.println(ANSI_RED + "Invalid option. Please try again." + ANSI_RESET);
                        }
                    }
                    break;
                case 2:
                    // Patron Management submenu loop
                    boolean backPatron = false;
                    while (!backPatron) {
                        System.out.println(ANSI_CYAN + "\n--- Patron Management ---" + ANSI_RESET);
                        System.out.println(ANSI_YELLOW + "1. Register Patron");
                        System.out.println("2. Display Patrons");
                        System.out.println("3. Back to Main Menu" + ANSI_RESET);
                        System.out.print(ANSI_PURPLE + "Select an option: " + ANSI_RESET);

                        int patronOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (patronOption) {
                            case 1:
                                // Register a new patron
                                System.out.print(ANSI_GREEN + "Enter patron name: " + ANSI_RESET);
                                String patronName = scanner.nextLine();
                                System.out.print(ANSI_GREEN + "Enter patron ID: " + ANSI_RESET);
                                String patronId = scanner.nextLine();
                                System.out.print(ANSI_GREEN + "Enter patron contact: " + ANSI_RESET);
                                String patronContact = scanner.nextLine();
                                Patron newPatron = new Patron(patronName, patronId, patronContact);
                                library.registerPatron(newPatron);
                                break;
                            case 2:
                                // Display all registered patrons
                                library.displayPatrons();
                                break;
                            case 3:
                                // Return to main menu
                                backPatron = true;
                                break;
                            default:
                                System.out.println(ANSI_RED + "Invalid option. Please try again." + ANSI_RESET);
                        }
                    }
                    break;
                case 3:
                    // Search submenu loop
                    boolean backSearch = false;
                    while (!backSearch) {
                        System.out.println(ANSI_CYAN + "\n--- Search Menu ---" + ANSI_RESET);
                        System.out.println(ANSI_YELLOW + "1. Search Books by Title");
                        System.out.println("2. Search Books by Author");
                        System.out.println("3. Search Books by ISBN");
                        System.out.println("4. Back to Main Menu" + ANSI_RESET);
                        System.out.print(ANSI_PURPLE + "Select an option: " + ANSI_RESET);

                        int searchOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (searchOption) {
                            case 1:
                                // Search books by title
                                System.out.print(ANSI_GREEN + "Enter title to search: " + ANSI_RESET);
                                String searchTitle = scanner.nextLine();
                                library.searchBooksByTitle(searchTitle);
                                break;
                            case 2:
                                // Search books by author
                                System.out.print(ANSI_GREEN + "Enter author to search: " + ANSI_RESET);
                                String searchAuthor = scanner.nextLine();
                                library.searchBooksByAuthor(searchAuthor);
                                break;
                            case 3:
                                // Search book by ISBN
                                System.out.print(ANSI_GREEN + "Enter ISBN to search: " + ANSI_RESET);
                                String searchISBN = scanner.nextLine();
                                library.searchBooksByISBN(searchISBN);
                                break;
                            case 4:
                                // Return to main menu
                                backSearch = true;
                                break;
                            default:
                                System.out.println(ANSI_RED + "Invalid option. Please try again." + ANSI_RESET);
                        }
                    }
                    break;
                case 4:
                    // Exit the application
                    exitMain = true;
                    System.out.println(ANSI_RED + "Exiting Library Management System." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid option. Please try again." + ANSI_RESET);
            }
        }
        // Close the scanner to free up resources
        scanner.close();
    }
}
