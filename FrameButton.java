import java.awt.event.*;
import javax.swing.*;

class FrameButton extends JButton implements ActionListener
{
  public FrameButton(String title)
  {
    this.setText(title);
    this.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if("calculate".equals(e.getActionCommand()))
    {
      Calculator.calculate();
    }
    if("power".equals(e.getActionCommand()))
    {
    }
    if("inductance".equals(e.getActionCommand()))
    {
    }
    if("capacity".equals(e.getActionCommand()))
    {
    }
  }
}