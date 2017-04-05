package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public Meal save(int userId, Meal meal) {
        return repository.save(userId, meal);
    }

    @Override
    public void delete(int userId, int id) throws NotFoundException{
        checkNotFoundWithId(repository.delete(userId, id),id);
    }

    @Override
    public Meal get(int userId, int id) throws NotFoundException{
        return checkNotFoundWithId(repository.get(userId,id),id);
    }

    @Override
    public Collection<Meal> getAll(int userId, String startDate, String endDate, String startTime, String endTime) {
        return repository.getAll(userId,startDate,endDate,startTime,endTime);
    }
}