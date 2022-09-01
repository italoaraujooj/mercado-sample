package com.italoramalh.mercadosample.services;

import com.italoramalh.mercadosample.exceptions.CartNotFoundException;
import com.italoramalh.mercadosample.exceptions.ProductNotFoundException;
import com.italoramalh.mercadosample.exceptions.UserNotFoundException;
import com.italoramalh.mercadosample.models.Cart;
import com.italoramalh.mercadosample.models.Category;
import com.italoramalh.mercadosample.models.Product;
import com.italoramalh.mercadosample.repositories.CartRepository;
import com.italoramalh.mercadosample.repositories.ProductRepository;
import com.italoramalh.mercadosample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRep;

    @Autowired
    private ProductService productService;

    public List<Cart> findAll(){
        return this.cartRep.findAll();
    }

    public Cart getOne(Long id){
        return cartRep.findById(id).orElse( new Cart());
    }

    public Cart save(Cart cart){
        return this.cartRep.save(cart);
    }

//    public Cart update(Long id, Cart cart){
//        Optional<Cart> u = this.cartRep.findById(id);
//
//        Cart update = null;
//
//        if(u.isPresent()){
//            update = u.get();
//
//            update.setName(Category.getName());
//            update.setDescription(Category.getDescription());
//        }
//
//        return update;
//    }

    public void addProductByUserId(Long id, Product product) throws UserNotFoundException {
        if (!productService.getOne(product.getId()).isAvailable()) productService.save(product);
        cartRep.findCartByUserId(id).orElseThrow(()-> new UserNotFoundException("Usuário não encontrado.")).addProduct(product);
    }

    public void delProductCartById(Long id, Product product) throws UserNotFoundException, ProductNotFoundException {
        Cart cart = cartRep.findCartByUserId(id).orElseThrow(()-> new UserNotFoundException("Usuário não encontrado."));
        if (cart.getProducts().contains(product)) cart.delProduct(product);
        else throw new ProductNotFoundException("Produto não encontrado");
    }

    public Cart getCart(Long id) throws CartNotFoundException {
        return this.cartRep.findCartByUserId(id).orElseThrow(()-> new CartNotFoundException("Cart não encontrado."));
    }
}
