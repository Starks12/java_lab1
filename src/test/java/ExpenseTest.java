import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExpenseTest {

    @Test
    public void testExpenseToString() {
        Category category = new Category("Food");
        Expense expense = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(category)
                .build();

        String expected = "Expense{amount=10.5, description='Lunch at a restaurant', category=Category{name='Food'}}";
        assertEquals(expense.toString(), expected);
    }

    @Test
    public void testExpenseEquals() {
        Category category = new Category("Food");
        Expense expense1 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(category)
                .build();

        Expense expense2 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(category)
                .build();

        Expense expense3 = new Expense.Builder()
                .setAmount(5.00)
                .setDescription("Dinner")
                .setCategory(new Category("Food"))
                .build();

        assertEquals(expense1, expense2); // should be true
        assertNotEquals(expense1, expense3); // should be false
    }

    @Test
    public void testExpenseHashCode() {
        Category category = new Category("Food");
        Expense expense1 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(category)
                .build();

        Expense expense2 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(category)
                .build();

        assertEquals(expense1.hashCode(), expense2.hashCode());
    }
}
