package com.example.Inventory.Controller;

import com.example.Inventory.Dto.InventoryDto;
import com.example.Inventory.Entity.Inventory;
import com.example.Inventory.Service.InventoryService;
import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    //Get the products.

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public JSONObject getProducts(@RequestParam int index, @RequestParam int size){

        JSONObject jsonObject = new JSONObject();

        try {
            List<Inventory> inventoryList = inventoryService.getProducts(index, size);

            List<InventoryDto> returnList = new ArrayList<>();

            for (Inventory inventory : inventoryList) {
                InventoryDto inventoryDto = new InventoryDto();
                BeanUtils.copyProperties(inventory, inventoryDto);
                returnList.add(inventoryDto);
            }

            jsonObject.put("status", true);
            jsonObject.put("data", returnList);

            return jsonObject;
        } catch (Exception ex){
            jsonObject.put("status", false);
            jsonObject.put("msg", "Error in getting products. Please contact the administration.");

        }
        return jsonObject;

    }


    //Decrease the stock on buying items.

    @RequestMapping(value = "/decreaseStock", method = RequestMethod.POST)
    public JSONObject decreaseStock(@RequestBody List<JSONObject> listOfItems){

        JSONObject jsonObject = new JSONObject();

        if(inventoryService.decreaseStock(listOfItems)) {
            jsonObject.put("status", true);
            jsonObject.put("msg", "Successfully updated data.");

        } else {
            jsonObject.put("status", false);
            jsonObject.put("msg", "Error in modifying data. Please contact administrator.");

        }

        return jsonObject;

    }


}
