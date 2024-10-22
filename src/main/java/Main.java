import model.Category;
import model.Expense;
import model.JsonSerializer;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        Category food = new Category("Food");
        Expense expense = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(food)
                .build();

        // Serialize to JSON
        JsonSerializer<Expense> jsonSerializer = new JsonSerializer<>(Expense.class);
        jsonSerializer.serialize(expense, new File("expense.json"));

        // Deserialize from JSON
        Expense deserializedExpense = jsonSerializer.deserialize(new File("expense.json"));
        System.out.println(deserializedExpense);
    }
}
