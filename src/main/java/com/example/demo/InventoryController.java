package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InventoryController {
	@Autowired
    Inventory ims;

    @PostMapping("/inventory/add")
    public ResponseEntity<String> addItemToInventory(@RequestParam String productId, @RequestParam int quantity) {
        ims.addItemToInventory(productId, quantity);
        return ResponseEntity.ok("Item added to inventory");
    }

    @DeleteMapping("/inventory/remove")
    public ResponseEntity<String> removeItemFromInventory(@RequestParam String productId, @RequestParam int quantity) {
        try {
            ims.removeItemFromInventory(productId, quantity);
            return ResponseEntity.ok("Item removed from inventory");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cart/add")
    public ResponseEntity<String> addItemToCart(@RequestParam String customerId, @RequestParam String productId, @RequestParam int quantity) {
        try {
            ims.addItemToCart(customerId, productId, quantity);
            return ResponseEntity.ok("Item added to cart");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cart/apply-discount")
    public ResponseEntity<Double> applyDiscountCoupon(@RequestParam double cartValue, @RequestParam String discountId) {
        try {
            double discountedValue = ims.applyDiscountCoupon(cartValue, discountId);
            return ResponseEntity.ok(discountedValue);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/discount/add")
    public ResponseEntity<String> addDiscountCoupon(@RequestParam String discountId, @RequestParam double percentage, @RequestParam double maxDiscount) {
        ims.addDiscountCoupon(discountId, percentage, maxDiscount);
        return ResponseEntity.ok("Discount coupon added");
    }
    
    @GetMapping("/inventory")
    public ResponseEntity<Map<String, Integer>> getInventory() {
        return ResponseEntity.ok(ims.getInventory());
    }

    @GetMapping("/cart")
    public ResponseEntity<Map<String, Integer>> getCart(@RequestParam String customerId) {
        return ResponseEntity.ok(ims.getCart(customerId));
    }
}
