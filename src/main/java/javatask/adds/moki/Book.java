package javatask.adds.moki;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {

    private Author author;
    private int issue;

    public Book(Author author, int issue) {
        this.author = author;
        this.issue = issue;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return issue == book.issue && Objects.equals(author, book.author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", issue=" + issue +
                '}';
    }
}

class Author {
    String name;
    boolean sex;
    int age;

    public Author(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return sex == author.sex && age == author.age && Objects.equals(name, author.name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}

class Gen {
    List<Book> get() {
        Author author = new Author("John", true, 30);
        Book book1 = new Book(author, 1998);
        Book book2 = new Book(author, 2011);
        Book book3 = new Book(new Author("Jane", false, 25), 1999);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }
}

class Service {

    private Author author;
    private Book book;
    private Gen gen;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }


    List<Book> getByAuthor(Author author) {

        List<Book> list = gen.get();

        return list.stream().filter(book -> book.getAuthor().equals(author))
                .toList();
    }


//    List<Book> m1(Book book, Author author) {
//        List<Book> list = new Gen().get();
//        return list.stream().filter(b -> b.getAuthor().equals(author) ||
//                b.equals(book)).toList();
//    }

    public static void main(String[] args) {

        Service s = new Service();

        Author author = new Author("John", true, 30);
        List<Book> list = s.getByAuthor(author);

        System.out.println(list);

    }

}
