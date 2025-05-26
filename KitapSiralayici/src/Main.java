import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book b1= new Book("Bir İdam Mahkumunun Son Günü","Victor Hugo","1829",130);
        Book b2= new Book("Bülbülü Öldürmek","Harper Lee","1960",360);
        Book b3= new Book("Cesur Yeni Dünya","Aldous Huxley","1932",272);
        Book b4= new Book("Muhteşem Gatsby","Francis Scott Key Fitzgerald","1925",176);
        Book b5= new Book("Fahrenheit 451","Ray Bradbury","1953",208);

        Set <Book> set= new TreeSet<>();
        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        set.add(b5);

        System.out.println("Kitap isimlerine göre sıralama: ");
        for(Book b:set){
            System.out.println(b.getName());
        }

        System.out.println();

        Set<Book> sortPageList=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {//Kitapları sayfa sayısına göre sıralar
                return o1.getNumberOfPages()- o2.getNumberOfPages();
            }
        });

       sortPageList.add(b1);
       sortPageList.add(b2);
       sortPageList.add(b3);
       sortPageList.add(b4);
       sortPageList.add(b5);
       
       System.out.println("Kitapları sayfa sayısına göre sıralama");
       for(Book s: sortPageList){
           System.out.println(s.getName()+": "+ s.getNumberOfPages());
       }
    }
}