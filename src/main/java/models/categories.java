package models;

public class categories {
    private int id;
    private String categories;

    public categories(){

    }
    public categories(int id, String categories) {
        this.id = id;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
