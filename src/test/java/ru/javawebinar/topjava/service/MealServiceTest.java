package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MealServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testSaveAdminMeal() throws Exception {
        Meal meal = new Meal(LocalDateTime.parse("2017-02-04T23:23"), "testMeal", 1000);
        Meal addedMeal = service.save(meal, ADMIN_ID);
        meal.setId(addedMeal.getId());
        MATCHER.assertEquals(meal, addedMeal);
    }

    @Test
    public void testGetAdminMeal() throws Exception {
        Meal meal = service.get(7, ADMIN_ID);
        assertTrue(adminMeals.contains(meal));
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFoundAdminMeal() throws Exception {
        Meal meal = service.get(1, ADMIN_ID);
        assertTrue(adminMeals.contains(meal));
    }

    @Test
    public void testDeleteUserMeal() throws Exception {
        Meal mealForDeletion = service.get(2, USER_ID);
        service.delete(2, USER_ID);
        Collections.sort(userMeals, Comparator.comparing(Meal::getId));
        System.out.print(mealForDeletion.getId());
        Meal mealFromList = userMeals.get(mealForDeletion.getId()-1);
        MATCHER.assertEquals(mealForDeletion,mealFromList);
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateNotFoundAdminMeal() {
        Meal meal = service.get(1,USER_ID);
        meal.setCalories(2000);
        service.update(meal,ADMIN_ID);
    }

    @Test(expected = NotFoundException.class)
    public void testGetDeleteFoundAdminMeal() {
        service.delete(7, USER_ID);
    }

    @Test
    public void testGetBetweenDates() throws Exception {
        List<Meal> dbMeals = service.getBetweenDates(LocalDate.parse("2017-04-11"), LocalDate.parse("2017-04-11"), USER_ID);
        Collections.sort(dbMeals, Comparator.comparingInt(Meal::getId));
        List<Meal> filteredUserMeals = userMeals.stream().filter(um -> um.getDate().equals(LocalDate.parse("2017-04-11"))).sorted(Comparator.comparingInt(Meal::getId)).collect(Collectors.toList());
        MATCHER.assertCollectionEquals(dbMeals, filteredUserMeals);
    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {
        List<Meal> dbMeals = service.getBetweenDateTimes(LocalDateTime.parse("2017-04-11 10:00", dateTimeFormatter), LocalDateTime.parse("2017-04-11 14:00", dateTimeFormatter), USER_ID);
        Collections.sort(dbMeals, Comparator.comparingInt(Meal::getId));
        List<Meal> filteredUserMeals = userMeals.stream()
                .filter(um -> um.getDateTime().isAfter((LocalDateTime.parse("2017-04-11 10:00", dateTimeFormatter))) || um.getDateTime().isEqual(LocalDateTime.parse("2017-04-11 10:00", dateTimeFormatter)))
                .filter(um -> um.getDateTime().isBefore(LocalDateTime.parse("2017-04-11 14:00", dateTimeFormatter)) || um.getDateTime().isEqual(LocalDateTime.parse("2017-04-11 14:00", dateTimeFormatter)))
                .sorted(Comparator.comparingInt(Meal::getId))
                .collect(Collectors.toList());
        MATCHER.assertCollectionEquals(filteredUserMeals, dbMeals);
    }

    @Test
    public void testGetAllAdmin() throws Exception {
        Collection<Meal> all = service.getAll(MealTestData.USER_ID);
        Collections.sort(userMeals, Comparator.comparing(Meal::getId).reversed());
        MATCHER.assertCollectionEquals(userMeals, all);
    }

    @Test
    public void testGetAllUser() throws Exception {
        Collection<Meal> all = service.getAll(MealTestData.ADMIN_ID);
        Collections.sort(adminMeals, Comparator.comparingInt(Meal::getId).reversed());
        MATCHER.assertCollectionEquals(adminMeals, all);
    }

    @Test
    public void testUpdateNotExsitingMealWillSave() throws Exception {
        Meal updatedMeal = new Meal();
        updatedMeal.setDescription("updated Meal");
        updatedMeal.setCalories(3000);
        updatedMeal.setDateTime(LocalDateTime.parse("2017-02-04T23:23"));
        service.update(updatedMeal, USER_ID);
        updatedMeal.setId(9);
        MATCHER.assertEquals(updatedMeal, service.get(updatedMeal.getId(), USER_ID));
    }

    @Test
    public void testUpdate() throws Exception {
        Meal updatedMeal = new Meal();
        updatedMeal.setDescription("updated Meal");
        updatedMeal.setCalories(3000);
        updatedMeal.setDateTime(LocalDateTime.parse("2017-02-04T23:23"));
        updatedMeal.setId(1);
        service.update(updatedMeal, USER_ID);
        MATCHER.assertEquals(updatedMeal, service.get(updatedMeal.getId(), USER_ID));
    }

    @Test(expected = NotFoundException.class)
    public void testGetAdminGetsUserMeal() throws Exception {
        service.get(1, ADMIN_ID);
    }

}