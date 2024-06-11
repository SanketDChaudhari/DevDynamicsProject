package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.model.Discount;

@Component
public class Inventory {
	
	private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Map<String, Integer>> carts = new HashMap<>();
    private Map<String, Discount> discounts = new HashMap<>();

    public void addItemToInventory(String productId, int quantity) {
        inventory.put(productId, inventory.getOrDefault(productId, 0) + quantity);
    }

    public void removeItemFromInventory(String productId, int quantity) {
        if (!inventory.containsKey(productId) || inventory.get(productId) < quantity) {
            throw new IllegalArgumentException("Insufficient inventory to remove the requested quantity.");
        }
        inventory.put(productId, inventory.get(productId) - quantity);
        if (inventory.get(productId) == 0) {
            inventory.remove(productId);
        }
    }

    public void addItemToCart(String customerId, String productId, int quantity) {
        if (!inventory.containsKey(productId) || inventory.get(productId) < quantity) {
            throw new IllegalArgumentException("Insufficient inventory to add to cart.");
        }

        carts.putIfAbsent(customerId, new HashMap<>());
        Map<String, Integer> cart = carts.get(customerId);
        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);

        inventory.put(productId, inventory.get(productId) - quantity);
    }

    public double applyDiscountCoupon(double cartValue, String discountId) {
        if (!discounts.containsKey(discountId)) {
            throw new IllegalArgumentException("Invalid discount ID.");
        }

        Discount discount = discounts.get(discountId);
        double discountAmount = (discount.getPercentage() / 100.0) * cartValue;
        if (discountAmount > discount.getMaxDiscount()) {
            discountAmount = discount.getMaxDiscount();
        }

        return cartValue - discountAmount;
    }

    public void addDiscountCoupon(String discountId, double percentage, double maxDiscount) {
        discounts.put(discountId, new Discount(percentage, maxDiscount));
    }
    
    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }

    public Map<String, Integer> getCart(String customerId) {
        return new HashMap<>(carts.getOrDefault(customerId, new HashMap<>()));
    }

}
