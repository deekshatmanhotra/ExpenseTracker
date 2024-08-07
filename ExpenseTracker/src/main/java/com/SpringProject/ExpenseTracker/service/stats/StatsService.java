package com.SpringProject.ExpenseTracker.service.stats;

import com.SpringProject.ExpenseTracker.dto.GraphDTO;
import com.SpringProject.ExpenseTracker.dto.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();

    StatsDTO getStats();
}
