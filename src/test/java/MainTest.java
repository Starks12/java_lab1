import model.Category;
import model.Expense;
import model.JsonSerializer;
import org.testng.annotations.Test;
import java.io.File;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testExpenseSerialization() throws Exception {
        Category food = new Category("Food");
        Expense expense = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(food)
                .build();

        JsonSerializer<Expense> jsonSerializer = new JsonSerializer<>(Expense.class);
        File file = new File("expense_test.json");

        // Serialize
        jsonSerializer.serialize(expense, file);

        // Deserialize
        Expense deserializedExpense = jsonSerializer.deserialize(file);

        // Assertions
        assertEquals(deserializedExpense.getAmount(), expense.getAmount());
        assertEquals(deserializedExpense.getDescription(), expense.getDescription());
        assertEquals(deserializedExpense.getCategory().getName(), expense.getCategory().getName());

        // Clean up
        file.delete();
    }
}
