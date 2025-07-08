public class EBook extends Book {
    

    public EBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author);
        
    }

    @Override
    public void deliver(String email, String address) {
        System.out.println("Quantum book store: Sending EBook '" + title + "' to email: " + email);
    }
}
