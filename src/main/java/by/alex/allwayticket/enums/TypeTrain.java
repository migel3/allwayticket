package by.alex.allwayticket.enums;

import java.io.Serializable;


public enum TypeTrain implements Serializable {
    HIGH_SPEED(1.1), FAST(1.0), PASSENGER(0.9);
    private double coefficient;

    TypeTrain(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public String getType() {
        return this.name();
    }
}
