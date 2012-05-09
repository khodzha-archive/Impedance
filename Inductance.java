import javax.swing.*;
import java.text.*;
import java.lang.*;

class Inductance extends Element
{
  public Inductance()
  {
    String str = JOptionPane.showInputDialog("Enter inductance value");
    double inductance = Double.parseDouble(str);
  }

  private double inductance;
}