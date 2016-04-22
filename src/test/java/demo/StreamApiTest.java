package demo;

import demo.naked.appointment.java8.behaviorParameterization.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static  java.util.stream.Collectors.*;
/**
 * Created by tm1c14 on 18/08/2015.
 */

@RunWith(value = MockitoJUnitRunner.class)
public class StreamApiTest {

    @Test
    public void testStreamSorting() {

        List<String> lowCalorieDishNames = menus().stream()
                                           .filter((Dish d) -> d.getCalories() < 370)
                                           .sorted(Comparator.comparing(Dish::getCalories))
                                           .map(Dish::getName)
                                           .collect(Collectors.toList());

        lowCalorieDishNames.forEach((name) ->{
            System.out.println(name);
        });
    }

    @Test
    public void threeHighCaloricDishNamesTest() {
        List<String> threeHighCaloricDishNames = menus()
                                                 .stream()
                                                 .filter((Dish d) -> d.getCalories() > 300)
                                                 .map(Dish::getName)
                                                 .limit(3)
                                                 .collect(toList());

        threeHighCaloricDishNames.forEach((name)->{
            System.out.println(name);
        });
    }

    @Test
    public void streamTraverseTest() {
        List<String> titles = Arrays.asList("Java8","In","Action");
        Stream<String> s = titles.stream();
        s.forEach(System.out::println);

        System.out.println(titles.stream().count());

        List<Dish> vegetarianDishes = menus()
                                      .stream()
                                      .filter(Dish::isVegetarian)
                                      .collect(toList());
        System.out.println("----------------------------------------------");
        vegetarianDishes.forEach((Dish dish) -> {
            System.out.println(dish.getName());
        });
    }

    @Test
    public void distinctTest() {
        List<Integer> integers = Arrays.asList(1,2,3,33,4,2,34,33);
        List<Integer> distinctIntegers = integers.stream().distinct().collect(toList());

        distinctIntegers.forEach((i)-> System.out.println(i));
    }

    public List<Dish> menus() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        return menu;

    }
}
