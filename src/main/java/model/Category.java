package model;

import java.util.Objects;

public class Category implements Comparable<Category> {
    private String name;

    // Default constructor for Jackson
    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{name='" + name + "'}"; // Correct output format
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Category o) {
        return this.name.compareTo(o.name); // Comparison by name
    }
}
