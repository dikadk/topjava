package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MealTestData {

    public static final int ADMIN_ID = 100001;
    public static final int USER_ID = 100000;

    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd HH:mm");

    private static final Meal userMeal1 = new Meal(1, LocalDateTime.parse("2017-04-11 10:00", dateTimeFormatter), "Breakfast", 500);
    private static final Meal userMeal2 = new Meal(2, LocalDateTime.parse("2017-04-11 14:00", dateTimeFormatter), "Lunch", 1000);
    private static final Meal userMeal3 = new Meal(3, LocalDateTime.parse("2017-04-11 20:34", dateTimeFormatter), "Dinner", 500);
    private static final Meal userMeal4 = new Meal(4, LocalDateTime.parse("2017-04-12 10:00", dateTimeFormatter), "Breakfast", 500);
    private static final Meal userMeal5 = new Meal(5, LocalDateTime.parse("2017-04-12 14:00", dateTimeFormatter), "Lunch", 1000);
    private static final Meal userMeal6 = new Meal(6, LocalDateTime.parse("2017-04-13 20:34", dateTimeFormatter), "Dinner", 510);

    private static final Meal adminMeal1 = new Meal(7, LocalDateTime.parse("2017-04-13 14:00", dateTimeFormatter), "Lunch", 1000);
    private static final Meal adminMeal2 = new Meal(8, LocalDateTime.parse("2017-04-13 20:34", dateTimeFormatter), "Dinner", 510);

    public static final List<Meal> userMeals = new ArrayList<Meal>() {{
            add(userMeal1);
            add(userMeal2);
            add(userMeal3);
            add(userMeal4);
            add(userMeal5);
            add(userMeal6);
    }};

    public static final List<Meal> adminMeals = new ArrayList<Meal>() {{
        add(adminMeal1);
        add(adminMeal2);
    }};

    public static ModelMatcher<Meal> MATCHER = new ModelMatcher<>((expected, actual) -> expected == actual ||
            (Objects.equals(expected.getId(), actual.getId()) && (Objects.equals(expected.getDateTime(), actual.getDateTime()))
                    && (Objects.equals(expected.getDescription(), actual.getDescription()))
                    && (Objects.equals(expected.getCalories(), actual.getCalories()))));

}
