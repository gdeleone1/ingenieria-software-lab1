package gt.edu.umg.ingenieria.sistemas.laboratorio1.model;

import java.io.Serializable;
import static javassist.CtMethod.ConstParameter.integer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Josué Barillas (jbarillas)
 */
@Entity
@Table(name="Cliente")
public class Client implements Serializable {

   @Id
 // @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
    private Long id;
    
   @Column(name="fistName")
    private String firstName;
    
    @Column(name="lastName")
    private String lastName;
    
    @Column(name="nit")
    public String nit;
    
    @Column(name="phone")
    public String phone;
    
    @Column(name="address")
    private String address;
    
       @Column(name="age")
    public int age;
    

    public Client() {
    }

    public Client(Long id, String firstName, String lastName, String nit, String phone, String address, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nit= nit;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getAge(){
        return age;
    }
      public void setAge(int  age) {
        this.age = age;
    }
    
}
