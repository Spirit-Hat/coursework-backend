package models;

public class product {
    private int id;
    private String title;

    private String description;
    private double oldprice;

    private double price;
    private boolean new_product;
    private boolean bestseller;
    private String logos;
    private String logos_alt;
    public product(int id, int id_categories, String title, double price, boolean new_product, boolean bestseller, String logos, String logos_alt) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.new_product = new_product;
        this.bestseller = bestseller;
        this.logos = logos;
        this.logos_alt = logos_alt;
    }

    public product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOldprice() {
        return oldprice;
    }

    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNew_product() {
        return new_product;
    }

    public void setNew_product(boolean new_product) {
        this.new_product = new_product;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    public String getLogos() {
        return logos;
    }

    public void setLogos(String logos) {
        this.logos = logos;
    }

    public String getLogos_alt() {
        return logos_alt;
    }

    public void setLogos_alt(String logos_alt) {
        this.logos_alt = logos_alt;
    }
}
