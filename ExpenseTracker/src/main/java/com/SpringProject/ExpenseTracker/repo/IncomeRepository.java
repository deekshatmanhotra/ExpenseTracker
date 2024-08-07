package com.SpringProject.ExpenseTracker.repo;

import com.SpringProject.ExpenseTracker.entity.Expense;
import com.SpringProject.ExpenseTracker.entity.Income;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("select sum(i.amount) from Income i")
    Double sumAllAmount();

    Optional<Income> findFirstByOrderByDateDesc();
}
