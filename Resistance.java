import javax.swing.*;
import java.text.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;

class Resistance extends Element
{
  public Resistance()
  {
    super();
    String str = JOptionPane.showInputDialog("Enter resistance value");
    this.resistance = Double.parseDouble(str);
    this.impedance = new Complex(this.resistance, 0.0);
  }

  public void Draw(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.yellow);
    g2.draw(new Line2D.Double(getfirstX(),getfirstY(),getsecondX(),getsecondY()));
    Ellipse2D circle1 = new Ellipse2D.Double(getfirstX()-5,getfirstY()-5,10,10);
    Ellipse2D circle2 = new Ellipse2D.Double(getsecondX()-5,getsecondY()-5,10,10);
    g2.draw(circle1);
    g2.fill(circle1);
    g2.draw(circle2);
    g2.fill(circle2);
  }
  private double resistance;
}