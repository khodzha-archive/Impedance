import javax.swing.*;
import java.text.*;
import java.lang.*;

class Resistance extends Element
{
  public Resistance()
  {
    String str = JOptionPane.showInputDialog("Enter resistance value");
    this.resistance = Double.parseDouble(str);
  }

  private double resistance;
}