import javax.swing.*;
import java.text.*;
import java.lang.*;

class PowerSupply extends Element
{
  public PowerSupply()
  {
    String str = JOptionPane.showInputDialog("Enter maximum voltage");
    double voltage_max = Double.parseDouble(str);
    str = JOptionPane.showInputDialog("Enter frequency");
    double frequency = Double.parseDouble(str);
  }

  private double voltage_max;
  private double frequency;
}