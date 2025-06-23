package com.example.demo_quan_ly_san_pham.repository;

import com.example.demo_quan_ly_san_pham.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("from Product p", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    public void saveOrUpdate(Product product) {
        Transaction transaction = null;
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
                session.merge(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.id =:id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            Transaction transaction = null;
            try (Session session = ConnectionUtil.sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.remove(product);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }

    }

    @Override
    public List<Product> searchByName(String keyword) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("select p from Product p where lower(p.name) like lower(concat('%',:keyword,'%'))", Product.class);
        query.setParameter("keyword", keyword);
        List<Product> products = query.getResultList();
        return products;
    }
}
