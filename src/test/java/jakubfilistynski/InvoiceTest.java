package jakubfilistynski;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InvoiceTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Test
  public void setSellerFirstName() throws EmptyLineException {
    thrown.expect(EmptyLineException.class);
    thrown.expectMessage("Empty name. Try again.");
    Invoice invoice = new Invoice(true);
    invoice.setSellerFirstName("\t");
  }

  @Test
  public void setSellerLastName() throws EmptyLineException {
    thrown.expect(EmptyLineException.class);
    thrown.expectMessage("Empty name. Try again.");
    Invoice invoice = new Invoice(true);
    invoice.setSellerFirstName("        \n ");

  }

  @Test
  public void setCustomerFirstName() throws EmptyLineException {
    thrown.expect(EmptyLineException.class);
    thrown.expectMessage("Empty name. Try again.");
    Invoice invoice = new Invoice(true);
    invoice.setCustomerFirstName("   \t     \n ");
  }

  @Test
  public void setCustomerLastName() throws EmptyLineException {
    thrown.expect(EmptyLineException.class);
    thrown.expectMessage("Empty name. Try again.");
    Invoice invoice = new Invoice(true);
    invoice.setCustomerLastName("   \t\t     \n ");
  }
}