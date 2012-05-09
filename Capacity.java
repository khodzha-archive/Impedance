import javax.swing.*;
import java.text.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;

class Capacity extends Element
{
  public Capacity()
  {
    String str = JOptionPane.showInputDialog("Enter capacity value");
    this.capacity = Double.parseDouble(str);
  }

  public void Draw(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.blue);
    g2.draw(new Line2D.Double(getfirstX(),getfirstY(),getsecondX(),getsecondY()));
  }
  
  private double capacity;
}