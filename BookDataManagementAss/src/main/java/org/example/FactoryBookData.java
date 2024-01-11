package org.example;

import resource.*;

public class FactoryBookData {
    private FactoryBookData() {
    }
    public static BookData getBookData(TypeBookData typeBookData){
        switch(typeBookData){
            case CSV:
                return new CSVBookData("src/main/resources/books.csv");
            case API:
                return new APIBookData();
            case MYSQL:
                return new MySQLBookData();
            default:
                throw new IllegalArgumentException("This book data type is unsupported");
        }
    };
}
