/**
 * A subclass of Product that represents a book.
 *
 * @author ckurdelak20@georgefox.edu
 */
public class Book extends Product
{
    private String _author;
    private String _publisher;

    public Book(String id, String desc, double price, String author, String publisher)
    {
        super(id, desc, price);

        _publisher = publisher;
        _author = author;
    }

    /**
     * Returns this Book's author.
     * @return this Book's author
     */
    public String getAuthor()
    {
        return _author;
    }

    /**
     * Returns this Book's publisher.
     * @return this Book's publisher
     */
    public String getPublisher()
    {
        return _publisher;
    }

    /**
     * Returns a String describing this Book.
     *
     * Example: "ID: BK_202, Description: Big Java: Early Objects, Price: 99.99,
     *          Author: Cay S. Horstmann, Publisher: Wiley"
     *
     * @return a String describing this Book
     */
    @Override
    public String toString()
    {
        return String.format("%s,%s,%s", super.toString(), _author, _publisher);
    }
}

