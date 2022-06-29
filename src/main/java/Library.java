import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Library {

    public static List<Book> bookList = new ArrayList<Book>();
    public static Map<String, Book> bookMap = new HashMap<String, Book>();
    public static Set<String> uniqueGenres = new HashSet<String>();

    public static void printBooks() {
        // If there are books in the library:
        System.out.println("");
        System.out.println("");
        System.out.println("These are the books in your library!");
        System.out.println("|");
        System.out.println("V");
        // Print library books:
        for (String title: bookMap.keySet()) {
            System.out.println(title);
            System.out.println(bookMap.get(title));
        }
        // Else, print sad face or ASCII art
    }

    public static void printBooksWGenres(String genre) {
        List<Book> booksWGenre = new ArrayList<Book>();
        for (Book book: bookList) {
            if(book.getGenre().equals(genre)) {
                System.out.println(book);
            }
        }
    // booksWGenre.stream().forEach(System.out::println);
    //  List<Book> bookGenres = bookList.stream()
    // .filter(b -> b.getGenre() === genre).collect(Collectors.toList());
    }
}
