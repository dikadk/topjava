package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealService {
    Meal save(int userId, Meal Meal);

    void delete(int userId, int id);

    Meal get(int userId, int id);

    Collection<Meal> getAll(int userId, String startDate, String endDate, String startTime, String endTime);
}