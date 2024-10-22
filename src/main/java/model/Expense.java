package model;

import java.util.Objects;

public class Expense implements Comparable<Expense> {
    private double amount;
    private String description;
    private Category category;

    // Default constructor for Jackson
    public Expense() {}

    // Builder class for constructing Expense instances
    public static class Builder {
        private double amount;
        private String description;
        private Category category;

        public Builder setAmount(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }
            this.amount = amount;
            return this;
        }

        public Builder setDescription(String description) {
            if (description == null || description.trim().isEmpty()) {
                throw new IllegalArgumentException("Description cannot be null or empty.");
            }
            this.description = description;
            return this;
        }

        public Builder setCategory(Category category) {
            if (category == null || category.getName() == null || category.getName().trim().isEmpty()) {
                throw new IllegalArgumentException("Category cannot be null and name cannot be empty.");
            }
            this.category = category;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }

    // Constructor for Builder
    private Expense(Builder builder) {
        this.amount = builder.amount;
        this.description = builder.description;
        this.category = builder.category;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
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

    @Override
    public int compareTo(Expense o) {
        return Double.compare(this.amount, o.amount);
    }
}
