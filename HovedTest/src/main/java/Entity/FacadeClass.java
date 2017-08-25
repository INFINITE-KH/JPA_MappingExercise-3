/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import enums.CustomerType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author KH
 */
public class FacadeClass {
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("jpaPU");
    EntityManager em = emf.createEntityManager();
    
    public void createCustomer(String firstName, String lastName, String phoneNumber, String phoneDescription, List<Address> addresses){
        em.getTransaction().begin();
        Customer c = new Customer(firstName, lastName);
        c.setCt(CustomerType.GOLD);
        c.addHobby("Fodbold");
        c.addPhone("12345678", "B. Mørks telefon");
        for(Address a : addresses){
            c.addAddresses(a);
        }
        em.persist(c);
        
        em.getTransaction().commit();
        em.close();
    }
}
