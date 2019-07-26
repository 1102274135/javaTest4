package bai.javatest4.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Customer implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private Integer adderssId;
    private String email;
    private int storeId=1;
    private int active=1;
    public Customer(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", adderssId=" + adderssId +
                ", email='" + email + '\'' +
                ", storeId=" + storeId +
                ", active=" + active +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAdderssId() {
        return adderssId;
    }

    public void setAdderssId(Integer adderssId) {
        this.adderssId = adderssId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
