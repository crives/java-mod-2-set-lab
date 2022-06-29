import java.util.Scanner;

/*
 * 
 * 1) In your library, create a set that contains a list of each genre that you have a book for
    2) Every time the user adds a book to the library, add the book's genre to your new set
    3) Add a new option to your loop to ask the user if they want to check if the library has any books of a specific genre
    4) If the user selects that option, ask them for the genre they want to check and them let them know if the library has any books of that genre.
*/

public class LibraryRunner {

    public static Scanner sc = new Scanner(System.in);
    public static boolean isGenrePresent = false;
    public static boolean repeat = true;
    public static String addBookMsg = "\n-- Would you like to: \n 1. Add a book \n 2. Look up an existing book \n 3. Search a book by genre \n 4. Print all books \n 5. Exit \n \nType the number of the option you choose from above:";
    public static String addBookMsgAgain = "\n-- Would you like to: \n 1. Add another book \n 2. Look up an existing book \n 3. Search a book by genre \n 4. View all books \n 5. Exit \n \nType the number of the option you choose from above:";
    public static String askTitle = "\nWhat is the title of the book you are searching?";
    public static String askGenre = "\nWhat is the genre of the book you are searching?";
    public static String foundBookByTitle = "\nThis is the book you are looking for:\n";
    public static String didNotFindByTitle = "\n*** \nSorry! We don't have that book in our records.... \n***";
    public static String noBooks = "\n*** \nThe library is empty at this time....no records! \n***";
    public static String containsGenre = "\nYes, we do have a book of that genre!\nSee below: \n";
    public static String noGenre = "\nSorry, we do not currently have a book of that genre!";

    public static void main(String[] args) {
        System.out.println("\nWelcome to the Virtual Book Library, where you can create and look up books!");
        intro();
    }

    public static void intro() {  
        while (repeat) {
            addBookMsg = Library.bookMap.isEmpty() ? addBookMsg : addBookMsgAgain;
            System.out.println(addBookMsg);
            int addBookAnswer = sc.nextInt();
            
            switch (addBookAnswer) {
                case 1:
                    String str = sc.nextLine();
                    addBook();
                    break;
                case 2:
                    String str1 = sc.nextLine();
                    System.out.println(askTitle);
                    String title = sc.nextLine();
                    lookUpTitle(title);
                    intro();
                    break;
                case 3:
                    String str2 = sc.nextLine();
                    System.out.println(askGenre);
                    String genre = sc.nextLine().toLowerCase();
                    lookUpGenre(genre);
                    intro();
                    break;
                case 4:
                    Library.printBooks();
                    intro();
                    break;
                case 5:       
                    System.out.println("\nGoodbye!"); 
                    repeat = false;
                    System.exit(0);
                    break;       
            }
                // Loop back to beginning for user input
                String str = sc.nextLine();
        }
    }

    public static void addBook() {
        System.out.println("\nWhat would you like this book to be called?");
        String title = sc.nextLine();
        System.out.println("\nWhat genre is this book?");
        String genre = sc.nextLine().toLowerCase();
        System.out.println("\nHow many pages does this book have?");
        int numPages = sc.nextInt();

        Book newBook = new Book(title, genre, numPages);
        Library.bookList.add(newBook);
        Library.bookMap.put(newBook.getTitle(), newBook);
        Library.uniqueGenres.add(genre);

        System.out.println("\n***** Book has been added! *****");
    }

    public static void lookUpTitle(String title) {
        String message = Library.bookMap.containsKey(title) 
            ? foundBookByTitle + Library.bookMap.get(title)
            : didNotFindByTitle;
        System.out.println(message);
   }

    public static void lookUpGenre(String genre) {
        boolean isGenrePresent = Library.uniqueGenres.contains(genre);
        String message1 = Library.bookMap.isEmpty()
            ? noBooks 
            : isGenrePresent
                ? containsGenre
                : noGenre;
        System.out.println(message1);

        if(isGenrePresent) {
            Library.printBooksWGenres(genre);
        }
    }  
}
