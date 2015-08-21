package demo.naked.appointment.java8.behaviorParameterization;

/**
 * Created by tm1c14 on 18/08/2015.
 */
public class Dish {

    private String name;
    private Integer calories = 0;
    private boolean vegetarian;
    private Type type;

    public Dish(String name, boolean vegetarian, Integer calories, Type type) {
        this.name = name;
        this.calories = calories;
        this.setType(type);
        this.vegetarian = vegetarian;
    }

    public Dish(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {  MEAT,FISH,OTHER }
}
