package ru.javawebinar.topjava.dao;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by dkiro on 3/28/17.
 */
public class MealDaoImpl implements MealDao {

    private static final Logger LOG = getLogger(MealDaoImpl.class);

    private List<Meal> mealList;

    public MealDaoImpl(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @Override
    public void create() {

    }

    @Override
    public void edit(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Meal getById(int id) {
       return null;
    }

    @Override
    public List<Meal> getAll() {
        LOG.debug("all users returned");
        if(mealList==null){
            mealList = new ArrayList<>();
        }
        return mealList;

    }
}
