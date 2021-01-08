package com.codegym.repository.impl;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        //        TypedQuery<Student> typedQuery =
//                BaseRepository.entityManager.createQuery(
//                        "select s from student s where s.id = :idStudent", Student.class);
//        typedQuery.setParameter("idStudent", id);

//        TypedQuery<Student> typedQuery2 =
//                BaseRepository.entityManager.createQuery(
//                        "select s from student s where s.id = ?1", Student.class);
//        typedQuery2.setParameter(1, id);

//        return typedQuery.getSingleResult();
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
//        Product product = findById(id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
