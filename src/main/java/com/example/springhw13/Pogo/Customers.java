package com.example.springhw13.Pogo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {

   private String ID , Username;

   private int balance;
}
