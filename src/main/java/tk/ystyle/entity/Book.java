package tk.ystyle.entity;

import java.io.Serializable;

/**
 * Created by 小奕 on 2014-06-28 23:16.
 */
public class Book implements Serializable{
    private static final long serialVersionUID = -4402392412217726278L;
    private String bookno;
    private String name;
    private String author;
    private String price;

    public Book() {
    }

    public Book(String bookno, String name, String author, String price) {
        this.bookno = bookno;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String bookno, String name) {
        this.bookno = bookno;
        this.name = name;
    }

    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookno='" + bookno + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
