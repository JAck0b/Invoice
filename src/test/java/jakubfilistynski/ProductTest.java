package jakubfilistynski;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;

import org.junit.rules.ExpectedException;

public class ProductTest {

  private Product product;

  @Before
  public void setUp() {
    product = new Product("nazwa", 1, 1, 1);
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void setName() throws EmptyLineException {
    thrown.expect(EmptyLineException.class);
    thrown.expectMessage("Empty name. Try again.");
    product.setName("   ");
  }

  @Test
  public void setQuantity() throws NegativeNumberException {
    thrown.expect(NegativeNumberException.class);
    thrown.expectMessage("Negative number.Try again.");
    product.setQuantity(-1);
  }

  @Test
  public void setPrice() throws NegativeNumberException {
    thrown.expect(NegativeNumberException.class);
    thrown.expectMessage("Negative number.Try again.");
    product.setPrice(-1);
  }
}