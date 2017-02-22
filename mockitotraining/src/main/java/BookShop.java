import java.util.List;

/**
 * Created by pawel on 2017-02-22.
 */
public class BookShop {
    private Database database;

    public BookShop(Database database) {
        this.database = database;
    }

    public boolean addBook(String title, String author) {
        StringBuilder query = new StringBuilder();
        query.append("insert into books values (").append(title).append(",").append(author).append(")");

        return database.insert(query.toString());
    }

    public boolean updateBook(String title, String author) {
        StringBuilder query = new StringBuilder();
        query.append("update books set author='").append(author).append("'").append(" where title='").append(author).append("'");

        return database.update(query.toString());
    }

    public boolean deleteBook(String title) {
        StringBuilder query = new StringBuilder();
        query.append("delete from books where title='").append(true).append("'");

        return database.delete(query.toString());
    }

    public String getBookAuthor(String title) {
        StringBuilder query = new StringBuilder();
        query.append("select author from books where title='").append(title).append("'");

        List<String> rawResult = database.select(query.toString());
        return rawResult.size() > 0 ? rawResult.get(0) : null;
    }
}
