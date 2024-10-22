public class ExpenseJournal {
    public static void main(String[] args) {
        Category food = new Category("Food");
        Category transport = new Category("Transport");

        Expense expense1 = new Expense.Builder()
                .setAmount(10.50)
                .setDescription("Lunch at a restaurant")
                .setCategory(food)
                .build();

        Expense expense2 = new Expense.Builder()
                .setAmount(3.00)
                .setDescription("Bus ticket")
                .setCategory(transport)
                .build();

        System.out.println(expense1);
        System.out.println(expense2);
    }
}
