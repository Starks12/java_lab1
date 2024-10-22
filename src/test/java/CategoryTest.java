import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CategoryTest {

    @Test
    public void testCategoryToString() {
        Category category = new Category("Food");
        assertEquals(category.toString(), "Category{name='Food'}");
    }

    @Test
    public void testCategoryEquals() {
        Category category1 = new Category("Food");
        Category category2 = new Category("Food");
        Category category3 = new Category("Transport");

        assertEquals(category1, category2); // should be true
        assertNotEquals(category1, category3); // should be false
    }

    @Test
    public void testCategoryHashCode() {
        Category category1 = new Category("Food");
        Category category2 = new Category("Food");

        assertEquals(category1.hashCode(), category2.hashCode());
    }
}
