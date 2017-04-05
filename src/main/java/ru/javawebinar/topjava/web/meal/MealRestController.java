package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

@Controller
public class MealRestController {

    private MealService service;

    @Autowired
    public void setService(MealService service){
        this.service = service;
    }

    public void save(int id, Meal meal) {
        service.save(id,meal);
    }

    public void delete(int userId, int id) {
        service.delete(userId, id);
    }

    public Meal get(int userId, int id) {
        return service.get(userId, id);
    }

    public List<MealWithExceed> getAll(int userId, String startDate, String endDate, String startTime, String endTime) {
        return MealsUtil.getWithExceeded(service.getAll(userId,startDate,endDate,startTime,endTime), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }
}