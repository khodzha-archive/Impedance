import java.awt.*;
import java.awt.event.*;

class Element implements MouseListener
{
  public void Draw()
  {
  }
  
  public void mouseClicked(MouseEvent e)
  {
    if(first_x == 0 && first_y == 0)
    {
      this.first_x = e.getX();
      this.first_y = e.getY();
    }
    else
    {
      this.second_x = e.getX();
      this.second_y = e.getY();
    }
  }
  
  public void mouseExited(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}

  public boolean isPlaced()
  {
    if (this.first_x != 0 && this.first_y !=0 && this.second_x !=0 && this.second_y !=0 )
      return true;
    else return false;
  }
  
  private int first_x, first_y;
  private int second_x, second_y;
}