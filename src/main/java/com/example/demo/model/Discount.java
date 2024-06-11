package com.example.demo.model;

public class Discount {
	private double percentage;
    private double maxDiscount;

    public Discount(double percentage, double maxDiscount) {
        this.percentage = percentage;
        this.maxDiscount = maxDiscount;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getMaxDiscount() {
        return maxDiscount;
    }
}
