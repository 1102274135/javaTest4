package bai.javatest4.model;

public class Address {
    private int id;
    private String address;
    public Address(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", adderss='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
