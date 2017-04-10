package ru.javawebinar.topjava.repository.mock;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {

    private static final Logger LOG = getLogger(InMemoryMealRepositoryImpl.class);
    private final Table<Integer, Integer, Meal> repository = HashBasedTable.create();
    private AtomicInteger counter = new AtomicInteger(0);
    private static final int ADMIN = 2;
    private static final int USER_1 = 1;

    {
        MealsUtil.MEALS.forEach(meal -> this.save(USER_1,meal));
        repository.put(ADMIN, 1, new Meal(1,LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        repository.put(ADMIN, 2, new Meal(2,LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
    }

    @Override
    public synchronized Meal save(int userId, Meal meal) {
        Objects.requireNonNull(meal);

        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
        }
        repository.put(userId,meal.getId(), meal);
        LOG.debug("userId:"+userId+" | "+meal.getId()+" is saved");
        return meal;
    }

    @Override
    public synchronized boolean delete(int userId, int id) {
        LOG.debug("userId:"+userId+" | "+id+" is deleted");
        return repository.remove(userId,id)!=null;
    }

    @Override
    public synchronized Meal get(int userId, int id) {
        LOG.debug("userId:"+userId+" | "+" is returned");
        return repository.get(userId,id);
    }

    @Override
    public synchronized Collection<Meal> getAll(int userId) {
        Map<Integer,Meal> meals = repository.row(userId);
        return meals == null ? Collections.emptyList() :meals.values().stream().sorted(Comparator.comparing(Meal::getDateTime).reversed()).collect(Collectors.toList());
       }
}

