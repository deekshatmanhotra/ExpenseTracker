package com.SpringProject.ExpenseTracker.service.income;

import com.SpringProject.ExpenseTracker.dto.ExpenseDTO;
import com.SpringProject.ExpenseTracker.dto.IncomeDTO;
import com.SpringProject.ExpenseTracker.entity.Expense;
import com.SpringProject.ExpenseTracker.entity.Income;
import com.SpringProject.ExpenseTracker.repo.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService{

    private final IncomeRepository incomeRepository;

    public Income postIncome(IncomeDTO incomeDTO){
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO){
        income.setTitle(incomeDTO.getTitle());
        income.setCategory(incomeDTO.getCategory());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepository.save(income);
    }

    public List<IncomeDTO> getAllIncome(){
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());
    }

    public Income updateExpense(Long id, IncomeDTO incomeDTO){

        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            return saveOrUpdateIncome(optionalIncome.get(), incomeDTO);
        }else{
            throw new EntityNotFoundException("Income is not found with id "+id);
        }

    }

    public Income getIncomeById(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            return  optionalIncome.get();
        }else{
            throw new EntityNotFoundException("Income is not present with id "+id);
        }
    }

    public void deleteIncome(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            incomeRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Income is not found with id "+id);
        }
    }



}
