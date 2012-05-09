import java.awt.event.*;
import javax.swing.*;

class FrameButton extends JButton implements ActionListener
{
  ArrayList<Element> array = new ArrayList<Element>();
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
      CalculateButton.setText("Click where to place contacts of the element");
      PowerSupplyButton.setEnabled(false);
      ResistanceButton.setEnabled(false);
      CapacityButton.setEnabled(false);
      CalculateButton.setEnabled(false);
      InductanceButton.setEnabled(false);
      DrawPanel.addMouseListener();
      PowerSupply power = new PowerSupply();
      array.add(power);
    }
    if("inductance".equals(e.getActionCommand()))
    {
      CalculateButton.setText("Click where to place contacts of the element");
      PowerSupplyButton.setEnabled(false);
      ResistanceButton.setEnabled(false);
      CapacityButton.setEnabled(false);
      CalculateButton.setEnabled(false);
      InductanceButton.setEnabled(false);
      DrawPanel.addMouseListener();
      Inductance inductance = new Inductance();
      array.add(inductance);
    }
    if("capacity".equals(e.getActionCommand()))
    {
      CalculateButton.setText("Click where to place contacts of the element");
      PowerSupplyButton.setEnabled(false);
      ResistanceButton.setEnabled(false);
      CapacityButton.setEnabled(false);
      CalculateButton.setEnabled(false);
      InductanceButton.setEnabled(false);
      DrawPanel.addMouseListener();
      Capacity capacity = new Capacity();
      array.add(capacity);
    }
    if("resistance".equals(e.getActionCommand()))
    {
      CalculateButton.setText("Click where to place contacts of the element");
      PowerSupplyButton.setEnabled(false);
      ResistanceButton.setEnabled(false);
      CapacityButton.setEnabled(false);
      CalculateButton.setEnabled(false);
      InductanceButton.setEnabled(false);
      DrawPanel.addMouseListener();
      Resistance resistance = new Resistance();
      array.add(resistance);
    }
  }
  
  private  ArrayList<Element> array;
}