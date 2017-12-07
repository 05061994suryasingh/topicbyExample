package com.chromeinfotech.Ui.CustomContentProvider;

/**
 * Created by user on 24/4/17.
 */

public class Bookinfo {
    String bookTitle ;
    String isbn;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Bookinfo(String bookTitle, String isbn) {

        this.bookTitle = bookTitle;
        this.isbn = isbn;
    }
}
