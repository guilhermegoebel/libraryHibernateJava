package test;

import dao.AuthorDao;
import dao.BookDao;
import model.Author;
import model.Book;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TestCRUD {
    public static void main(String[] args){
        EntityManager em = JPAUtil.getEntityManager();
        AuthorDao authorDao = new AuthorDao(em);
        BookDao bookDao = new BookDao(em);



        em.getTransaction().begin();

        em.getTransaction().commit();
        em.close();
    }
}
