package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

/**
 * Created by dkiro on 3/28/17.
 */
public interface MealDao {
    void create();
    void edit(int id);
    void delete(int id);
    Meal getById(int id);
    List<Meal> getAll();


}
