package forPractice.work1;

public class Cars {

    private String brand;
    private String model;
    private int price;
    private String country;

    public Cars(String brand, String model, int price, String country){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.country = country;
    }

    public Cars(){

    }



    public String setBrand(String brand){
        return brand;
    }

    public String setModel(String model){
        return model;
    }

    public int setPrice(int price){
        return price;
    }

    public String setCountry(String country){
        return country;
    }

    public String getBrand(){ return this.brand; }

    public String getModel(){ return this.model; }

    public int getPrice(){ return this.price; }

    public String getCountry(){ return this.country; }

    @Override
    public String toString() {
        return "Cars{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                '}';
    }
}
