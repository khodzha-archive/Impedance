import javax.swing.*;
import java.text.*;
import java.lang.*;

class PowerSupply extends Element
{
  public PowerSupply()
  {
    String str = JOptionPane.showInputDialog("Enter maximum voltage");
    this.voltage_max = Double.parseDouble(str);
    str = JOptionPane.showInputDialog("Enter frequency");
    this.frequency = Double.parseDouble(str);
  }

  private double voltage_max;
  private double frequency;
}