
import java.util.*;

public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book '" + book.getTitle() + "'");
    }

    public List<Book> removeOutdatedBooks(int maxAge, int currentYear) {
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next().getValue();
            if (currentYear - book.getPublishYear() > maxAge) {
                removed.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book '" + book.getTitle() + "'");
            }
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        if (!inventory.containsKey(isbn)) {
            throw new IllegalArgumentException("Quantum book store: Book with ISBN " + isbn + " not found");
        }

        Book book = inventory.get(isbn);

        if (book instanceof ShowcaseBook) {
            throw new IllegalArgumentException("Quantum book store: Cannot buy Showcase book");
        }

        if (book instanceof PaperBook) {
            ((PaperBook) book).reduceStock(quantity);
        }

        double total = book.getPrice() * quantity;
        for (int i = 0; i < quantity; i++) {
            book.deliver(email, address);
        }
        System.out.println("Quantum book store: Total amount paid: $" + total);
        return total;
    }
}
