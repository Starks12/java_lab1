import java.util.Objects;

public class Expense {
    private double amount;
    private String description;
    private Category category;

    private Expense(Builder builder) {
        this.amount = builder.amount;
        this.description = builder.description;
        this.category = builder.category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.amount, amount) == 0 &&
                description.equals(expense.description) &&
                category.equals(expense.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description, category);
    }

    public static class Builder {
        private double amount;
        private String description;
        private Category category;

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }
}
