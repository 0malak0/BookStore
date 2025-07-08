public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (stock < quantity) {
            throw new IllegalArgumentException("Quantum book store: Not enough stock for " + title);
        }
        stock -= quantity;
    }

    @Override
    public void deliver(String email, String address) {
        System.out.println("Quantum book store: Shipping PaperBook '" + title + "' to address: " + address);
    }
}

