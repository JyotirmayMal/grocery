package com.shop.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.grocery.repo.GroceryRepo;
import com.shop.grocery.model.GroceryItem;


@Service
public class GroceryService 
{
    @Autowired
    private GroceryRepo groceryRepo;
    public List<GroceryItem> getAllItems() 
    {
      return groceryRepo.findAll(); // Fetch all items from DB
    }

  public GroceryItem getItem(int pid) 
  {
      return groceryRepo.findById(pid).orElse(null); // Fetch item by ID
  }

  public GroceryItem addItem(GroceryItem item) 
  {
      return groceryRepo.save(item); // Save new item to DB
  }

  public GroceryItem updateItem(int pid, GroceryItem updatedItem) 
  {
      GroceryItem existingItem = groceryRepo.findById(pid).orElse(null);
      if (existingItem != null) 
      {
          existingItem.setName(updatedItem.getName());
          existingItem.setCategory(updatedItem.getCategory());
          existingItem.setPrice(updatedItem.getPrice());
          return groceryRepo.save(existingItem); // Save updated item
      }
      return null;
  }

  public void deleteItem(int pid) 
  {
      groceryRepo.deleteById(pid); // Delete item by ID
  }
}
