package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by dkiro on 3/27/17.
 */
public class MealServlet extends HttpServlet {

    private static final Logger LOG = getLogger(MealServlet.class);
    private MealDao mealDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        LOG.debug(action);
        mealDao = new MealDaoImpl();
        if (action == null) {
            LOG.debug("redirect to meals");
            List<MealWithExceed> mealWithExceeds = MealsUtil.getFilteredWithExceeded(mealDao.getAll(), LocalTime.MIN, LocalTime.MAX, 2000);
            request.setAttribute("mealsList", mealWithExceeds);
            request.getRequestDispatcher("meals.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            LOG.debug(request.getParameter("id") + " was deleted");
            mealDao.delete(id);
            response.sendRedirect("meals");
        } else if (action.equalsIgnoreCase("addMeal")) {
            LOG.debug("redirect to mealForm");
            response.sendRedirect("mealForm.jsp");
        }
        else if (action.equalsIgnoreCase("edit")) {
            LOG.debug("redirect to mealForm for edit");
            request.setAttribute("meal", mealDao.getById(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("mealForm.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("post form");
        request.setCharacterEncoding("UTF-8");
        mealDao = new MealDaoImpl();
        LocalDateTime localDateTime = LocalDateTime.parse(request.getParameter("dateTime").trim().replace(" ", "T"));
        Meal meal = new Meal(localDateTime, request.getParameter("description"), Integer.parseInt(request.getParameter("calories")));
        String mealId = request.getParameter("id");
        if(mealId==null || mealId.isEmpty()){
            mealDao.create(meal);
        }
        else{
            meal.setId(Integer.parseInt(mealId));
            mealDao.edit(meal);
        }
        response.sendRedirect("meals");
    }

}
