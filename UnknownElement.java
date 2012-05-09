import javax.swing.*;
import java.text.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;

class UnknownElement extends Element
{
  public UnknownElement()
  {
    this.impedance = 0;
  }

  public void Draw(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.black);
    g2.draw(new Line2D.Double(getfirstX(),getfirstY(),getsecondX(),getsecondY()));
  }
  
  private double impedance;
}