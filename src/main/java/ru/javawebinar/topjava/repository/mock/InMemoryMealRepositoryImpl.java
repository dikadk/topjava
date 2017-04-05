package ru.javawebinar.topjava.repository.mock;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Repository
public class InMemoryMealRepositoryImpl implements MealRepository {

    private static final Logger LOG = getLogger(InMemoryMealRepositoryImpl.class);
    private final Table<Integer, Integer, Meal> repository = HashBasedTable.create();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(meal -> this.save(1,meal));
    }

    @Override
    public synchronized Meal save(int userId, Meal meal) {
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
        Collection<Meal> meals = new ArrayList<>();
        for(Table.Cell<Integer, Integer, Meal> cell: repository.cellSet()){
            if(cell.getRowKey()==userId){
                meals.add(cell.getValue());
            }
        }
        return meals.stream().sorted(Comparator.comparing(Meal::getDateTime).reversed()).collect(Collectors.toList());
    }
}

