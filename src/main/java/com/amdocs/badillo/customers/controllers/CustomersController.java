package com.amdocs.badillo.customers.controllers;

import com.amdocs.badillo.customers.entities.Action;
import com.amdocs.badillo.customers.entities.Customer;
import com.amdocs.badillo.customers.entities.Product;
import com.amdocs.badillo.customers.entities.ServiceRequest;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CustomersController implements Serializable {

    private HashMap<Long,Customer> customerList;

    public CustomersController(){

        try( ObjectInputStream in = new ObjectInputStream( new FileInputStream("data/customer.ser") ) ) {

            customerList = (HashMap<Long,Customer>) in.readObject();

        } catch ( FileNotFoundException | ClassNotFoundException e) {
            customerList = new HashMap<>();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //curl localhost:8080/customers
    @GetMapping("/customers")
    public List<Customer> all(){

        ArrayList<Customer> allCustomers = new ArrayList<>( customerList.values() );
        return allCustomers;
    }

    //curl -X POST localhost:8080/customers -H 'Content-type:application/json' -d '{"id":"50", "name":"Ioannis PRAPAS", "photo":"Ioannis.jpg"}'
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer newCustomer){

        System.out.println("BADILLO: "+newCustomer);

        if (!customerList.containsKey(newCustomer.getId())) {

            customerList.put(newCustomer.getId(), newCustomer);

            save();

            return newCustomer;

        }

        throw new RuntimeException("Customer "+ newCustomer.getId()+" already exists." );

    }

    //curl -X PUT localhost:8080/customers/2 -H 'Content-type:application/json' -d '{"name":"Jose BADILLO", "photo":"jose.jpg"}'
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long id){

        System.out.println("BADILLO: "+customer);

        if (customerList.containsKey(id)) {

            Customer c = customerList.get(id);
            c.setName(customer.getName());
            c.setPhoto(customer.getPhoto());
            save();

            return c;

        }

        throw new RuntimeException("Could not find customer " + id);

    }

    //curl -X DELETE localhost:8080/customers/0
    @DeleteMapping("/customers/{id}")
    void deleteEmployee(@PathVariable long id) {

        customerList.remove(id);
        save();

    }

    public void save(){
        try (ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("data/customer.ser") )){
            out.writeObject(customerList);
            System.out.printf("Serialized data is saved in data/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
