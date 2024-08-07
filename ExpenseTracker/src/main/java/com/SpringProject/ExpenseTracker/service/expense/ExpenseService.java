package com.SpringProject.ExpenseTracker.service.expense;

import com.SpringProject.ExpenseTracker.dto.ExpenseDTO;
import com.SpringProject.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
