package Esercizi.SpringBoot.Develhope_Spring.component;

import org.springframework.stereotype.Component;

@Component
public class ResturantConfig {
    private double minPrice = 5.5;
    private double todaysDiscount = 1.5;
    private double maxPrice = 30.00;
    private boolean localePieno;
    public ResturantConfig(){
    }

    public boolean isLocalePieno() {
        return localePieno;
    }

    public void setLocalePieno(boolean localePieno) {
        this.localePieno = localePieno;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }
    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
    public double getTodaysDiscount() {
        return todaysDiscount;
    }
    public void setTodaysDiscount(double todaysDiscount) {
        this.todaysDiscount = todaysDiscount;
    }
}
