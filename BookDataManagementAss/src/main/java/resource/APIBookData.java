package resource;

import model.Book;

import java.util.List;

public class APIBookData implements BookData{
    public APIBookData(){
        throw new RuntimeException("API is not supported!");
    }
    @Override
    public List<Book> getBooks() {
        return null;
    }
}
