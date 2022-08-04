package com.developnetwork.mahmoud.service.models;

import java.util.List;

public class ProductModel {
    private int id;
    private String title;
    private String description;
    private int price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getShowingPrice() {
        return price + " LE";
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public List<String> getImages() {
        return images;
    }

    public class GetProducts {
        private List<ProductModel> products;
        private int total;
        private int skip;
        private int limit;

        public List<ProductModel> getProducts() {
            return products;
        }

        public int getTotal() {
            return total;
        }

        public int getSkip() {
            return skip;
        }

        public int getLimit() {
            return limit;
        }
    }
}
