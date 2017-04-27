package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {


    List<Meal> findAllByUserId(Sort sort, int userId);

    @Transactional
    int deleteByIdAndUserId(int id,int userId);

    Meal findOneByIdAndUserId(int id,int userId);

    @Query("SELECT m FROM Meal m WHERE m.user.id=:userId AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC")
    List<Meal> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);

    @Transactional
    @Override
    Meal save(Meal entity);

}
