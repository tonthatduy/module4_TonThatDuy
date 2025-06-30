package com.example.demo_cart.controller;

import com.example.demo_cart.model.Cart;
import com.example.demo_cart.model.Product;
import com.example.demo_cart.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ShoppingController {
    private final IProductService productService;

    public ShoppingController(IProductService productService) {
        this.productService = productService;
    }


    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute(name = "cart", required = false) Cart cart){
        if(cart == null){
            cart = new Cart();
        }
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/shopping-cart/remove")
    public String removeProduct (@RequestParam Long id, @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart/decrease")
    public String decreaseQuantity(@RequestParam Long id, @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        cart.decreaseProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart/increase")
    public String increaseQuantity(@RequestParam Long id, @ModelAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        cart.increaseQuantity(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart/payment")
    public String payment( @ModelAttribute("cart") Cart cart){
        cart.cleanAll();
        return "redirect:/shopping-cart";
    }
}
