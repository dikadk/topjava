package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by dkiro on 3/27/17.
 */
public class MealServlet extends HttpServlet {

    private static final Logger LOG = getLogger(MealServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to meals");

        response.sendRedirect("meals.jsp");
    }
}
