package com.codegym.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.File;

@Repository
public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure(new File("D:\\ChuongTrinhCodegym\\C0720G1_LeManhCuong_Module_4\\05.Database_ORM\\Bai_tap\\product-manager\\src\\main\\resources\\hibernate.conf.xml"))
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
