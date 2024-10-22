package services;

import model.Category;
import model.Expense;

import java.util.*;
import java.util.stream.Collectors;


public class ExpenseService {

    // Method to get costs sorted by amount
    public List<Expense> getExpensesSortedByAmount(List<Expense> expenses) {
        return expenses.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // A method for obtaining expenses by category
    public List<Expense> getExpensesByCategory(List<Expense> expenses, Category category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    // A method for obtaining unique cost categories
    public Set<Category> getUniqueCategories(List<Expense> expenses) {
        return expenses.stream()
                .map(Expense::getCategory)
                .collect(Collectors.toSet());
    }
}
