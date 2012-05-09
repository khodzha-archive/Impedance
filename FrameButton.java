import java.awt.event.*;
import javax.swing.*;
import java.util.*;

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
      MainFrame.DisableButtons();
      DrawPanel.addMouseListener();
      PowerSupply power = new PowerSupply();
      array.add(power);
    }
    if("inductance".equals(e.getActionCommand()))
    {
      MainFrame.DisableButtons();
      DrawPanel.addMouseListener();
      Inductance inductance = new Inductance();
      array.add(inductance);
    }
    if("capacity".equals(e.getActionCommand()))
    {
      MainFrame.DisableButtons();
      DrawPanel.addMouseListener();
      Capacity capacity = new Capacity();
      array.add(capacity);
    }
    if("resistance".equals(e.getActionCommand()))
    {
      MainFrame.DisableButtons();
      DrawPanel.addMouseListener();
      Resistance resistance = new Resistance();
      array.add(resistance);
    }
  }
  
  private  ArrayList<Element> array;
}