package resource;

import model.Book;

import java.util.List;

public class MySQLBookData implements BookData{
    public MySQLBookData(){
        throw new RuntimeException("MySQLBookData is not supported!");
    }
    @Override
    public List<Book> getBooks() {
        return null;
    }
}
