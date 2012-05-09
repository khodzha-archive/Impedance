import javax.swing.*;
import java.text.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;

class Resistance extends Element
{
  public Resistance()
  {
    String str = JOptionPane.showInputDialog("Enter resistance value");
    this.resistance = Double.parseDouble(str);
  }

  public void Draw(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.yellow);
    g2.draw(new Line2D.Double(getfirstX(),getfirstY(),getsecondX(),getsecondY()));
  }
  private double resistance;
}