package 老马书城;

import java.io.Serializable;

public class Book implements Serializable {
    private int no ;
    private String author;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public Book(int no, String author, String name) {
        this.no = no;
        this.author = author;
        this.name = name;
    }

    public Book() {
    }

    public void setName(String name) {
        this.name = name;
    }
}
