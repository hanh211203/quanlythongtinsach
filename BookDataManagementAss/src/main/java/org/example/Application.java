package org.example;

import model.Book;
import model.BookImpl;
import resource.BookData;
import resource.TypeBookData;
import resource.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {


    public static void menu(){
        System.out.println("************MENU***********");
        System.out.println("1. List of books - ISBN and title only");
        System.out.println("2. Search books by author, title or ISBN code");
        System.out.println("3. Sort the books by rating in ascending order");
        System.out.println("4. Take out the 10 books with the highest rating");
    }
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BookData bookData = FactoryBookData.getBookData(TypeBookData.CSV);
        List<Book> books = bookData.getBooks();
        int opt = -1;
        do{
            menu();
            System.out.print("Enter your choice: ");
            opt = Integer.parseInt(sc.nextLine());

            switch(opt){
                case 1:
                    System.out.println("1. List of books");
                    for(int i=0;i<books.size();i++){
                        System.out.println("Book "+(i+1)+"{" +
                                "title=" + books.get(i).getTitle() +
                                ", isbn=" + books.get(i).getIsbn() +
                                '}');
                    }
                    break;
                case 2:
                    System.out.print("Enter a book name or a book isbn or a book author: ");
                    String input = sc.nextLine();
                    System.out.println("The result of your search: ");
                    int count=0;
                    try{
                        for(Book book : books){
                            if(book.getTitle().toLowerCase().contains(input.toLowerCase())
                                    || book.getIsbn().toLowerCase().contains(input.toLowerCase())
                                    || book.getAuthors().toLowerCase().contains(input.toLowerCase())){
                                System.out.println(book);
                                count=count+1;
                            }
                        }
                    }catch(InputMismatchException e){
                            System.out.println("Invalid input");
                    }finally{
                        System.out.println("Finished!");
                    }
                    if(count==0){
                        System.out.println("No any book match your search!");
                    }
                    break;
                case 3:
                    System.out.println("The book list after sorting: ");
                    Collections.sort(books, new Comparator<Book>() {
                                @Override
                                public int compare(Book o1, Book o2) {
                                    return o1.getAverageRating() > o2.getAverageRating() ? 1 : -1;
                                }
                            });
                    for(int i=0;i<books.size();i++){
                        System.out.println("Book "+(i+1)+"{" +
                                "title=" + books.get(i).getTitle() +
                                ", author=" + books.get(i).getAuthors() +
                                ", averating=" + books.get(i).getAverageRating() +
                                '}');
                    }
                    break;
                case 4:
                    System.out.println("Top 10 books with the highest rating!");

                    Collections.sort(books, new Comparator<Book>() {
                        @Override
                        public int compare(Book o1, Book o2) {
                            return o1.getAverageRating() < o2.getAverageRating() ? 1 : -1;
                        }
                    });
                    for(int i=0;i<10;i++){
                        System.out.println("Book "+(i+1)+"{" +
                                "title=" + books.get(i).getTitle() +
                                ", author=" + books.get(i).getAuthors() +
                                ", averating=" + books.get(i).getAverageRating() +
                                '}');
                    }
                    break;
                default:
                    break;
            }
        }while(opt != 0);

    }
}