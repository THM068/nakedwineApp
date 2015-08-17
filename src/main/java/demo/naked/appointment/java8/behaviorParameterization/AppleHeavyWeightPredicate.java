package demo.naked.appointment.java8.behaviorParameterization;

/**
 * Created by tm1c14 on 17/08/2015.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {


    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
