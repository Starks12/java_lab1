import model.Category;
import model.Expense;
import org.testng.annotations.Test;
import services.ExpenseService;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExpenseServiceTest {

    @Test
    public void testGetExpensesSortedByAmount() {
        // Create an ExpenseService instance
        ExpenseService service = new ExpenseService();

        // Create some expenses
        Category food = new Category("Food");
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense.Builder().setAmount(20.00).setDescription("Dinner").setCategory(food).build());
        expenses.add(new Expense.Builder().setAmount(10.00).setDescription("Lunch").setCategory(food).build());
        expenses.add(new Expense.Builder().setAmount(5.00).setDescription("Snack").setCategory(food).build());

        // Get sorted expenses
        List<Expense> sortedExpenses = service.getExpensesSortedByAmount(expenses);

        // Verify the order
        assertEquals(sortedExpenses.get(0).getAmount(), 5.00, "First expense should be the smallest");
        assertEquals(sortedExpenses.get(1).getAmount(), 10.00, "Second expense should be the next smallest");
        assertEquals(sortedExpenses.get(2).getAmount(), 20.00, "Last expense should be the largest");
    }

    @Test
    public void testGetExpensesByCategory() {
        // Create an ExpenseService instance
        ExpenseService service = new ExpenseService();

        // Create some expenses
        Category food = new Category("Food");
        Category transport = new Category("Transport");
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense.Builder().setAmount(10.00).setDescription("Lunch").setCategory(food).build());
        expenses.add(new Expense.Builder().setAmount(5.00).setDescription("Bus ticket").setCategory(transport).build());
        expenses.add(new Expense.Builder().setAmount(20.00).setDescription("Dinner").setCategory(food).build());

        // Get food expenses
        List<Expense> foodExpenses = service.getExpensesByCategory(expenses, food);

        // Verify the size and content
        assertEquals(foodExpenses.size(), 2, "There should be 2 food expenses");
        assertTrue(foodExpenses.stream().allMatch(e -> e.getCategory().equals(food)), "All expenses should belong to the Food category");
    }

    @Test
    public void testGetUniqueCategories() {
        // Create an ExpenseService instance
        ExpenseService service = new ExpenseService();

        // Create some expenses
        Category food = new Category("Food");
        Category transport = new Category("Transport");
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense.Builder().setAmount(10.00).setDescription("Lunch").setCategory(food).build());
        expenses.add(new Expense.Builder().setAmount(5.00).setDescription("Bus ticket").setCategory(transport).build());
        expenses.add(new Expense.Builder().setAmount(20.00).setDescription("Dinner").setCategory(food).build());

        // Get unique categories
        Set<Category> uniqueCategories = service.getUniqueCategories(expenses);

        // Verify the size
        assertEquals(uniqueCategories.size(), 2, "There should be 2 unique categories");
    }
}
