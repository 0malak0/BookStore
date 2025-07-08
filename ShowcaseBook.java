public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author);
    }

    @Override
    public void deliver(String email, String address) {
        throw new UnsupportedOperationException("Quantum book store: Showcase books cannot be delivered");
    }
}
