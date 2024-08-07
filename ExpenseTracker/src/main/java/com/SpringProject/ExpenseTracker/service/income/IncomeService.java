package com.SpringProject.ExpenseTracker.service.income;

import com.SpringProject.ExpenseTracker.dto.IncomeDTO;
import com.SpringProject.ExpenseTracker.entity.Income;

import java.util.List;

public interface IncomeService {

    Income postIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncome();

    Income updateExpense(Long id, IncomeDTO incomeDTO);

    Income getIncomeById(Long id);

    void deleteIncome(Long id);

}
