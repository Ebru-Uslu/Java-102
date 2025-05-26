import java.util.Comparator;

public class Book implements Comparable <Book> {

    private String name;
    private String author;
    private String publicationDate;
    private int numberOfPages;

    public Book(String name,String author,String publicationDate,int numberOfPages){
        this.name=name;
        this.author=author;
        this.publicationDate=publicationDate;
        this.numberOfPages=numberOfPages;
    }

    @Override
    public int compareTo(Book book) {//Kitapları a'dan z'ye sıralar
        return getName().compareTo(book.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
