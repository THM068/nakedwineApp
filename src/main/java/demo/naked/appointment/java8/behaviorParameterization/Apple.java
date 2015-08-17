package demo.naked.appointment.java8.behaviorParameterization;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tm1c14 on 17/08/2015.
 */
public class Apple {

     private String color;
     private int weight;

    public Apple(){}

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
