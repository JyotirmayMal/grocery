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
        return groceryRepo.getAllItems();
    }
    public void addItems(GroceryItem item)
    {
      groceryRepo.addItems(item);
    }
    public GroceryItem getItems( int pid) {
      return groceryRepo.getItems(pid);
  }




  public GroceryItem updateItem(int pid, GroceryItem item) 
  {
    return groceryRepo.updateItem(pid, item);
  }

  public String deleteItem(int pid)
  {
    return groceryRepo.deleteItem(pid);
  }
}
