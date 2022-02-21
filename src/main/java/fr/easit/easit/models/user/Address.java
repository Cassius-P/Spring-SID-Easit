package fr.easit.easit.models.user;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    public Address(){}
    public Address(String address1, String address2){
        this.setAddress1(address1);
        this.setAddress2(address2);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(nullable = false)
    private String address1;
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(nullable = false)
    private String address2;
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String adress2) {
        this.address2 = adress2;
    }

    @OneToOne(mappedBy = "livingAddress")
    private User userLivingAddress;
    public User getUserFromLivingAddress() {
        return userLivingAddress;
    }

    @OneToOne(mappedBy = "invoiceAddress")
    private User userInvoiceAddress;
    public User getUserFromInvoiceAddress() {
        return userInvoiceAddress;
    }


}
