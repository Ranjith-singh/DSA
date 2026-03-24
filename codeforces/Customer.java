import java.util.HashSet;
import java.util.Set;

public class Customer {

    private final String customerId; // The unique identifier

    private String name;

    private int age;
 
    public Customer(String customerId, String name, int age) {

        this.customerId = customerId;

        this.name = name;

        this.age = age;

    }
 
    public String getCustomerId() {

        return customerId;

    }

}
 
public void addCustomer() {

Set<Customer> uniqueCustomers = new HashSet<>();

//Code to fetch data from DB and add to his object is available here.

while () {

     Customer c = new Customer(idFromFile, nameFromFile, ageFromFile);

     uniqueCustomers.add(c);

}

}
