package dao;

import model.Author;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorDao {

    private EntityManager em;

    public AuthorDao(EntityManager em){
        this.em = em;
    }

    public void createAuthor(Author author){
        this.em.persist(author);
    }

    public Author findById(Long id) {
        return em.find(Author.class, id);
    }

    public void deleteAuthor(Author author){
        author = em.merge(author);
        this.em.remove(author);
    }

    public void updateAuthor(Author author){
        this.em.merge(author);
    }

    public List<Author> getAll(){
        String jpql = "SELECT a FROM Author a";
        return em.createQuery(jpql, Author.class).getResultList();
    }

}
