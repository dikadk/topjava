package ru.javawebinar.topjava.dao;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by dkiro on 3/28/17.
 */
public class MealDaoImpl implements MealDao {

    private static final Logger LOG = getLogger(MealDaoImpl.class);
    private static int id;
    private static Map<Integer, Meal> meals;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    static {
        meals = new ConcurrentHashMap<>();
        Meal meal1 = new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500);
        Meal meal2 = new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000);
        Meal meal3 = new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500);

        Meal meal4 = new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510);
        Meal meal5 = new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000);
        Meal meal6 = new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500);

        meal1.setId(getId());
        meal2.setId(getId());
        meal3.setId(getId());
        meal4.setId(getId());
        meal5.setId(getId());
        meal6.setId(getId());

        meals.put(meal1.getId(), meal1);
        meals.put(meal2.getId(), meal2);
        meals.put(meal3.getId(), meal3);
        meals.put(meal4.getId(), meal4);
        meals.put(meal5.getId(), meal5);
        meals.put(meal6.getId(), meal6);
    }

    @Override
    public void create(Meal meal) {
        LOG.debug("meal " + id + " was created");
        meals.put(getId(), meal);
    }

    @Override
    public void edit(int id) {
        LOG.debug("meal " + id + " was edited");
    }

    @Override
    public void delete(int id) {
        LOG.debug("meal " + id + " was removed");
        meals.remove(id,meals.get(id));
        LOG.debug(String.valueOf(meals.size()));
    }

    @Override
    public Meal getById(int id) {
        return null;
    }

    @Override
    public List<Meal> getAll() {
        LOG.debug("all users returned");
        List<Meal> mealsList = meals.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        return mealsList;
    }

    public static int getId() {
        id = atomicInteger.incrementAndGet();
        return id;
    }


}
