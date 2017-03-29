package ru.javawebinar.topjava.dao;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
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
    private static ConcurrentMap<Integer, Meal> meals;
    private AtomicInteger atomicInteger = new AtomicInteger(meals.size());

    static {
       meals = new ConcurrentHashMap<>();

    }


    @Override
    public void create(Meal meal) {
        LOG.debug("meal "+id+" was created");
        meals.put(getId(),meal);
    }

    @Override
    public void edit(int id) {
        LOG.debug("meal "+id+" was edited");
    }

    @Override
    public void delete(int id) {
        LOG.debug("meal "+id+" was removed");
        meals.remove(meals.get(id));
    }

    @Override
    public Meal getById(int id) {
       return null;
    }

    @Override
    public List<Meal> getAll() {
        LOG.debug("all users returned");
        List<Meal> mealsList = meals.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());
        return mealsList;
    }


    public static List<Meal> getMealsList() {
        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        return meals;
    }

    public int getId(){
        id = atomicInteger.incrementAndGet();
        return id;
    }
}
