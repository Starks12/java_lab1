package journal;

import model.Category;
import model.Expense;
import services.ExpenseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExpenseJournalDemo {
    public static void main(String[] args) {
        Category food = new Category("Food");
        Category transport = new Category("Transport");

        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense.Builder().setAmount(10.50).setDescription("Lunch").setCategory(food).build());
        expenses.add(new Expense.Builder().setAmount(5.00).setDescription("Bus ticket").setCategory(transport).build());
        expenses.add(new Expense.Builder().setAmount(20.00).setDescription("Dinner").setCategory(food).build());

        ExpenseService expenseService = new ExpenseService();

        // Get expenses sorted by amount
        List<Expense> sortedExpenses = expenseService.getExpensesSortedByAmount(expenses);
        System.out.println("Sorted Expenses: " + sortedExpenses);

        // Obtaining expenses by category
        List<Expense> foodExpenses = expenseService.getExpensesByCategory(expenses, food);
        System.out.println("Food Expenses: " + foodExpenses);

        // Obtaining unique categories
        Set<Category> uniqueCategories = expenseService.getUniqueCategories(expenses);
        System.out.println("Unique Categories: " + uniqueCategories);
    }
}
