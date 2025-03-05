package com.shop.grocery.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GroceryItem 
{
    private int pid;
    private String name;
    private String catagory;
    private double price;
}
