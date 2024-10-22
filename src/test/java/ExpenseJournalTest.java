import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExpenseJournalTest {

    @Test
    public void testCreateAndPrintExpenses() {
        Category food = new Category("Food");
        Expense expense = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(food)
                .build();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        System.out.println(expense);

        String expectedOutput = "Expense{amount=10.5, description='Lunch at a restaurant', category=Category{name='Food'}}\n";
        assertEquals(outContent.toString(), expectedOutput);

        System.setOut(System.out);
    }
}
