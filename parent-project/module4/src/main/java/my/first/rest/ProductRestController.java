package my.first.rest;

import my.first.model.ProductInfo;
import my.first.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductInfo>> getAll() {
        List<ProductInfo> products = productService.getAll();
        return new ResponseEntity<>(
                products,
                HttpStatus.OK);
    }
}
