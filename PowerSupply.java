import java.awt.geom.*;
import javax.swing.*;
import java.text.*;
import java.lang.*;
import java.awt.*;

class PowerSupply extends Element
{
  public PowerSupply()
  {
    String str = JOptionPane.showInputDialog("Enter maximum voltage");
    this.voltage_max = Double.parseDouble(str);
    str = JOptionPane.showInputDialog("Enter frequency");
    this.frequency = Double.parseDouble(str);
  }
  
  public void Draw(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.red);
    g2.draw(new Line2D.Double(getfirstX(),getfirstY(),getsecondX(),getsecondY()));
  }
  
  private double voltage_max;
  private double frequency;
}