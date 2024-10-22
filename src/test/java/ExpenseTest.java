import model.Category;
import model.Expense;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExpenseTest {

    @Test
    public void testExpenseCreation() {
        // Create a category
        Category food = new Category("Food");

        // Create an expense using the Builder
        Expense expense = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(food)
                .build();

        // Assertions
        assertEquals(expense.getAmount(), 10.50, "Amount should match");
        assertEquals(expense.getDescription(), "Lunch at a restaurant", "Description should match");
        assertEquals(expense.getCategory(), food, "Category should match");
    }

    @Test
    public void testToString() {
        // Create a category and an expense
        Category food = new Category("Food");
        Expense expense = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch")
                .setCategory(food)
                .build();

        // Expected string representation
        String expectedOutput = "Expense{amount=10.5, description='Lunch', category=Category{name='Food'}}";
        assertEquals(expense.toString(), expectedOutput, "toString() should match expected output");
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create two expenses
        Category food = new Category("Food");
        Expense expense1 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch")
                .setCategory(food)
                .build();

        Expense expense2 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch")
                .setCategory(food)
                .build();

        // Check equality
        assertEquals(expense1, expense2, "Expenses should be equal");
        assertEquals(expense1.hashCode(), expense2.hashCode(), "Hash codes should match");
    }

    @Test
    public void testCompareTo() {
        // Create two expenses
        Category food = new Category("Food");
        Expense expense1 = new Expense.Builder()
                .setAmount(5.00)
                .setDescription("Snack")
                .setCategory(food)
                .build();

        Expense expense2 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch")
                .setCategory(food)
                .build();

        // Compare expenses
        assertTrue(expense1.compareTo(expense2) < 0, "expense1 should be less than expense2");
        assertTrue(expense2.compareTo(expense1) > 0, "expense2 should be greater than expense1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testExpenseCreationWithNegativeAmount() {
        // Create a category
        Category food = new Category("Food");

        // Attempt to create an expense with a negative amount
        new Expense.Builder()
                .setAmount(-10.50)
                .setDescription("Invalid expense")
                .setCategory(food)
                .build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testExpenseCreationWithEmptyDescription() {
        // Create a category
        Category food = new Category("Food");

        // Attempt to create an expense with an empty description
        new Expense.Builder()
                .setAmount(10.50)
                .setDescription("")
                .setCategory(food)
                .build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testExpenseCreationWithNullCategory() {
        // Attempt to create an expense with a null category
        new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch")
                .setCategory(null)
                .build();
    }
}
