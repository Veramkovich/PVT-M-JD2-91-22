package my.first.web;

import my.first.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ProductListController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product-list.html")
    public ModelAndView showProductList() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> products = restTemplate.getForEntity(
                "http://localhost:8080/rest/products",
                List.class);

        //productService.getAll()
        return new ModelAndView(
                "product_list",
                Map.of("products", products)
        );
        /*return new ModelAndView(
                "product_list",
                Map.of("products", productService.getAll())
        );*/
    }



}
