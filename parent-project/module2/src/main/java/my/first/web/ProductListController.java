package my.first.web;

import my.first.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ProductListController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product-list.html")
    public ModelAndView showProductList() {
        return new ModelAndView(
                "product_list",
                Map.of("products", productService.getAll())
        );
    }

}
