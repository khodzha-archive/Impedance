import javax.swing.*;
import java.text.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;

class Inductance extends Element
{
  public Inductance()
  {
    String str = JOptionPane.showInputDialog("Enter inductance value");
    this.inductance = Double.parseDouble(str);
  }
  
  public void Draw(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.green);
    g2.draw(new Line2D.Double(getfirstX(),getfirstY(),getsecondX(),getsecondY()));
  }

  private double inductance;
}