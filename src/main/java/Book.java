public class Book {
    public String title;
    public String genre;
    public int numPages;

    // Created getters and setters so class is not so empty
    public Book(String title, String genre, int numPages) {
        this.title = title;
        this.genre = genre;
        this.numPages = numPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
    
    @Override
    public String toString() {
        return "Details: { Title: " + title + " | Genre: " + genre + " | Number of Pages: " + numPages + " }";
    }
}
