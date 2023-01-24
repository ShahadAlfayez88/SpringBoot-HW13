package com.example.springhw13.Controller;

import com.example.springhw13.Pogo.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bankmanger")
public class BankController {

    ArrayList<Customers> customers = new ArrayList<Customers>();

    // display - worked
    @GetMapping("/display") //do homework
    public ArrayList<Customers> displayCustomer(){
        return customers;
    }

    // add new customers
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customers customer){
        customers.add(customer);
        return "Customer have been added";
    }
    // update
    @PutMapping("/update/{index}")
    public String updateCustomer(@PathVariable int index, @RequestBody Customers customer){
        customers.set(index, customer);
        return "Customer information have been Updated";
    }

    // delete
    @DeleteMapping("/delete/{index3}")
    public String deleteCustomer(@PathVariable int index3){
        customers.remove(index3);
        return "customer have been Deleted";

    }

    // Balance - Deposit
    @GetMapping("/Deposit/{id}/{amount}")
    Optional<Customers> balanceDeposit(@PathVariable String id , @PathVariable int amount) {
        for (Customers customer : customers) {
            if (id.equals(customer.getID())) {
                customer.setBalance(customer.getBalance()+amount);
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    // Balance - Withdraw
    @GetMapping("/Withdraw/{id}/{amount}")
    Optional<Customers> balanceWithdraw(@PathVariable String id , @PathVariable int amount) {
        for (Customers customer : customers) {
            if (id.equals(customer.getID())) {
                if (amount>customer.getBalance()){
                    System.out.println("there is insufficient balance in the customer's account");
                }else{
                    customer.setBalance(customer.getBalance()-amount);
                    return Optional.of(customer);
                }
            }
        }
        return Optional.empty();
    }


}
