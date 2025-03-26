package Spring.practice.product;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class productsController {
    private final ProductService productService;

    //    @RequestMapping(path = "/products", method = RequestMethod.POST)
//    public String addProduct(
//            @RequestParam String name,
//            @RequestParam double price,
//            Model model
//    ) {
//        Product p = new Product();
//        p.setName(name);
//        p.setPrice(price);
//        productService.addProduct(p);
//
//        var products = productService.findAll();
//        model.addAttribute("products", products);
//    }
    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProducts(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ){
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        var products = productService.findAll();
        model.addAttribute(p);
        return "products.html";
    }

}
