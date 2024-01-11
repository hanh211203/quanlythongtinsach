package resource;

import com.opencsv.CSVReader;
import model.Book;
import model.BookImpl;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
public class CSVBookData implements BookData{

    private String pathCsv;
    public CSVBookData(String pathCsv) {
        this.pathCsv = pathCsv;
    }
    public String getPathCsv() {
        return pathCsv;
    }
    public void setPathCsv(String pathCsv) {
        this.pathCsv = pathCsv;
    }
    @Override
    public List<Book> getBooks() {
        /*tại đây viết chương trình đọc thông tin từ file .csv
        và trả về đối tượng sách*/
        List<Book> books = new ArrayList<>();
        final int COL_ID=0,
                COL_ISBN =5,
                COL_TITLE=10,
                COL_AUTHORS = 7,
                COL_AVERAGE_RATING = 12,
                COL_LANGUAGE = 11,
                COL_YEAR = 8;
        try(Reader reader = Files.newBufferedReader(new File(pathCsv).toPath()) ) {
            CSVReader csvReader = new CSVReader(reader);
            csvReader.readNext();

            while(true){
                String[] row = csvReader.readNext();
                if(row!=null && row.length>0){
                    BookImpl book = new BookImpl();
                    book.setId(Long.parseLong(row[COL_ID]));
                    book.setIsbn(row[COL_ISBN]);
                    book.setTitle(row[COL_TITLE]);
                    book.setAuthor(row[COL_AUTHORS]);
                    book.setAverageRating(NumberUtils.toDouble(row[COL_AVERAGE_RATING]));
                    book.setLanguage(row[COL_LANGUAGE]);
                    book.setYear(NumberUtils.toInt(row[COL_YEAR]));
                    books.add(book);
                }else{
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;

    }
}
