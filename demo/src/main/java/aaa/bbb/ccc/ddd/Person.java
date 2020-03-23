package aaa.bbb.ccc.ddd;

import java.util.List;

import org.dominokit.jacksonapt.annotation.JSONMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/3/20
 */
@JSONMapper
public class Person {

    private String firstName;
    private String lastName;
    private List<Person> childs;


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getChilds() {
        return childs;
    }

    public void setChilds(List<Person> childs) {
        this.childs = childs;
    }
}
