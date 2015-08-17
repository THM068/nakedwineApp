package demo;

import demo.naked.appointment.java8.behaviorParameterization.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tm1c14 on 17/08/2015.
 */
@RunWith(value = MockitoJUnitRunner.class)
public class AppleInventoryUtilTest {



    @Test
    public void filterGreenColors() {
        ApplePredicate greenPredicate = new AppleGreenColorPredicate();

        List<Apple> result = AppleInventoryUtil.filterApples(appleList(), greenPredicate);

        assert  result.size() == 3;
    }

    @Test
    public void filterGreenColorsIambda() {
        List<Apple> result = AppleInventoryUtil.filterApples(appleList(), (Apple apple) -> "green".equals(apple.getColor()));
        assert  result.size() == 3;
    }

    @Test
    public void filterGreenColorsIambda_general() {
        List<Apple> result = AppleInventoryUtil.filter(appleList(), (Apple apple) -> "green".equals(apple.getColor()));
        assert  result.size() == 3;
    }

    @Test
    public void printAppleWeight() {
        AppleFormatter formatter = new PrintAppleWeightFormatter();
        AppleInventoryUtil.prettyPrintApple(appleList(), formatter);
        assert true;
    }

    private List<Apple> appleList() {
        List<Apple> apples = new ArrayList<>();

        Apple a1 = new Apple("green", 140);
        apples.add(a1);
        Apple a2 = new Apple("blue", 160);
        apples.add(a2);
        Apple a3 = new Apple("green", 130);
        apples.add(a3);
        Apple a4 = new Apple("yellow", 120);
        apples.add(a4);
        Apple a5 = new Apple("green", 170);
        apples.add(a5);
        Apple a6 = new Apple("purple", 165);
        apples.add(a6);

        Comparator<Apple> comparator = (Apple a11, Apple a22) -> {
            return a11.getWeight().compareTo(a22.getWeight());
        };
        apples.sort((comparator));

        return apples;
    }

    @Test
    public void testFileFilter() {
        File f = new File(".");
        String[] files = f.list((File file, String fileName) -> {
            return file.isDirectory();
        });

        for(String fileNames: files) {
            System.out.println(fileNames);
        }
    }
}
