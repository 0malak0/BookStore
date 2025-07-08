public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        store.addBook(new PaperBook("ISBN001", "Java Basics", 2015, 150.0, "ALi", 10));
        store.addBook(new EBook("ISBN002", "AI Book", 2020, 80.0, "Ahmed"));
        store.addBook(new ShowcaseBook("ISBN003", "cs book", 2000, 0.0, "Malak"));
        store.buyBook("ISBN001", 2, "user@gmail.com", "Cairo, Egypt");

    
        store.buyBook("ISBN002", 1, "reader@gmail.com", "No address");

    
        try {
            store.buyBook("ISBN003", 1, "x@y.com", "No address");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        store.removeOutdatedBooks(10, 2025);
    }
}
