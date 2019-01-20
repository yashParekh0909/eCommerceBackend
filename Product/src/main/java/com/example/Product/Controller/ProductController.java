package com.example.Product.Controller;

import com.example.Product.Dto.ProductDto;
import com.example.Product.Entity.Product;
import com.example.Product.Service.ProductService;
import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //Display the detail about the product.

    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public ProductDto getProduct(@RequestParam String productId){
        Product product = productService.getProduct(productId);

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

}
