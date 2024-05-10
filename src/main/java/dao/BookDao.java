package dao;

import model.Book;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDao {

    private EntityManager em;

    public BookDao(EntityManager em){
        this.em = em;
    }

    public void createBook(Book book){
        this.em.persist(book);
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public void deleteBook(Book book){
        book = em.merge(book);
        this.em.remove(book);
    }

    public void updateBook(Book book){
        this.em.merge(book);
    }

    public List<Book> getAll(){
        String jpql = "SELECT b FROM Book b";
        return em.createQuery(jpql, Book.class).getResultList();
    }
}
