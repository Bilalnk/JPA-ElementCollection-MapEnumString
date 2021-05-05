package com.proje.test;

import com.proje.model.Personel;
import com.proje.model.util.PhoneType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();


        Personel personel = new Personel("Bilal", "Karatas", new Date());

        personel.addPhoneNumber(PhoneType.Ev, "0312545865");
        personel.addPhoneNumber(PhoneType.CEP, "5456548546");
        personel.addPhoneNumber(PhoneType.IS, "03012546846");

        entityTransaction.begin();

        entityManager.persist(personel);

        entityTransaction.commit();

    }
}
