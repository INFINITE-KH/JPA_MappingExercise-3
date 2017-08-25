package Tester;

import Entity.Address;
import Entity.Book;
import Entity.Customer;
import enums.CustomerType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Test {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
               
        Book b = new Book();
        b.setTitle("KH");
        em.persist(b);
        
        Book b1 = new Book();
        b1.setTitle("KL");
        em.persist(b1);
        
        Book b2 = new Book();
        b2.setTitle("Lasse");
        em.persist(b2);
        
        Customer c = new Customer("Brian", "Mørk");
        c.setCt(CustomerType.GOLD);
        c.addHobby("Fodbold");
        c.addPhone("12345678", "B. Mørks telefon");
        c.addAddresses(new Address("Hundige", "Greve"));
        c.addAddresses(new Address("Hunasdasdse", "Gasdasdae"));
        em.persist(c);
        
        Customer c1 = new Customer("Casper", "Vang");
        c1.setCt(CustomerType.SILVER);
        c1.addHobby("Boksning");
        c1.addPhone("87654321", "C. Vangs telefon");
        em.persist(c1);
        
        em.getTransaction().commit();
        em.close();
    }
}
