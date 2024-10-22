import model.Category;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CategoryTest {

    @Test
    public void testCategoryCreation() {
        // Create a category
        Category category = new Category("Food");
        assertEquals(category.toString(), "Category{name='Food'}", "toString() should match expected output");
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create two categories
        Category category1 = new Category("Transport");
        Category category2 = new Category("Transport");

        // Check equality
        assertEquals(category1, category2, "Categories should be equal");
        assertEquals(category1.hashCode(), category2.hashCode(), "Hash codes should match");
    }

    @Test
    public void testCompareTo() {
        // Create two categories
        Category category1 = new Category("Food");
        Category category2 = new Category("Transport");

        // Compare categories
        assertTrue(category1.compareTo(category2) < 0, "category1 should be less than category2");
        assertTrue(category2.compareTo(category1) > 0, "category2 should be greater than category1");
    }
}
