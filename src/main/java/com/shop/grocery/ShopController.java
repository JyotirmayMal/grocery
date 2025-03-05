package com.shop.grocery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shop.grocery.model.GroceryItem;
import com.shop.grocery.service.GroceryService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ShopController {

    @Autowired
    private GroceryService groceryService; 
    @GetMapping("/")
    public List<GroceryItem> getAllItems()
    {
        return groceryService.getAllItems();
    }
    @GetMapping("/{pid}")
    public GroceryItem getItems(@PathVariable("pid") int pid) 
    {
        return groceryService.getItems(pid);
    }
    @PostMapping("/")
    public GroceryItem addItems(@RequestBody GroceryItem item) 
    {
        groceryService.addItems(item);
        return groceryService.getItems(item.getPid());
    }



    //Update n item
    @PutMapping("/{pid}")
    public GroceryItem updateItem(@PathVariable("pid") int pid, @RequestBody GroceryItem item) {
        return groceryService.updateItem(pid, item);
    }

    // Delete an item
    @DeleteMapping("/{pid}")
    public String deleteItem(@PathVariable("pid") int pid) {
        return groceryService.deleteItem(pid);
    }
    
}
