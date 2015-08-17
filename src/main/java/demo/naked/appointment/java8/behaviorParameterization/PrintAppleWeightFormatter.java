package demo.naked.appointment.java8.behaviorParameterization;

/**
 * Created by tm1c14 on 17/08/2015.
 */
public class PrintAppleWeightFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        int appleWeight = apple.getWeight();

        return String.format("An Apple of %dg", appleWeight);
    }
}
