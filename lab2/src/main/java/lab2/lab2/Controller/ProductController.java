package lab2.lab2.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lab2.lab2.Model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @GetMapping("/getAll")
    public String getProducts() {
        return products.toString();
    }

    @RequestMapping("/")
    public String openPage() {
        return "productPage.html";
    }

    @GetMapping("/:prodId")
    public String getProductbyId(@PathVariable int prodId) {
        Product prod = null;
        for (Product p : products) {
            if (p.getId() == prodId) {
                prod = p;
            }
        }
        if (prod == null)
            throw new Error("Product Not Found");
        else {
            return String.valueOf(prod);
        }
    }

    @RequestMapping("/add")
    public String addProduct(@RequestParam int prodId, @RequestParam String name, @RequestParam String desc,
            @RequestParam double price, Model model) {
        model.addAttribute("id", prodId);
        model.addAttribute("name", name);
        model.addAttribute("description", desc);
        model.addAttribute("price", price);
        return "productPage.html";
    }

}
