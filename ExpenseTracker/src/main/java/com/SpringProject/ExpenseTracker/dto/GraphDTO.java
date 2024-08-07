package com.SpringProject.ExpenseTracker.dto;

import com.SpringProject.ExpenseTracker.entity.Expense;
import com.SpringProject.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;

}
