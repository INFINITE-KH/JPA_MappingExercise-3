package Entity;

import enums.CustomerType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private CustomerType ct;
    @ElementCollection()
    private List<String> hobbies = new ArrayList();
    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "PHONE")
    @Column(name="Description")
    private Map<String,String> phones = new HashMap();
    @OneToMany
    (cascade=CascadeType.PERSIST)
    @JoinColumn(name="CUSTOMER_ID")
    private List<Address> addresses = new ArrayList<>();

    public CustomerType getCt() {
        return ct;
    }

    public void setCt(CustomerType ct) {
        this.ct = ct;
    }
    
    public void addHobby(String s){
        this.hobbies.add(s);
    }

    public List<String> getHobbies() {
        return hobbies;
    }
    
    public void addPhone(String phoneNo, String description){
        this.phones.put(phoneNo, description);
    }
    
    public void addAddresses(Address add){
        this.addresses.add(add);
    }    
    
    public Map<String, String> getPhones() {
        return phones;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Customer() {
    }

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Customer[ id=" + id + " ]";
    }
    
}
