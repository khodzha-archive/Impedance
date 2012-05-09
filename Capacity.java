import javax.swing.*;
import java.text.*;
import java.lang.*;

class Capacity extends Element
{
  public Capacity()
  {
    String str = JOptionPane.showInputDialog("Enter capacity value");
    double capacity = Double.parseDouble(str);
  }

  private double capacity;
}