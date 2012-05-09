import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MainFrame extends JFrame implements ActionListener
{
  public MainFrame()
  {
    super("Impedance Calculator");
    this.CalculateButton = new FrameButton("Calculate");
    this.elementPanel = new ElementsPanel(this);

    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    JPanel buttonsPanel = new JPanel(new FlowLayout());
    buttonsPanel.add(CalculateButton);
    add(buttonsPanel, BorderLayout.SOUTH);

    this.CalculateButton.setVerticalTextPosition(AbstractButton.CENTER);
    this.CalculateButton.setHorizontalTextPosition(AbstractButton.LEADING);
    this.CalculateButton.setActionCommand("calculate");
    this.CalculateButton.addActionListener(this);

    add(this.elementPanel, BorderLayout.NORTH);

    this.drawPanel = new DrawPanel();
    add(this.drawPanel, BorderLayout.CENTER);
  }

  public void DisableButtons()
  {
    CalculateButton.setText("Click where to place contacts of the element");
    CalculateButton.setEnabled(false);
    elementPanel.DisableButtons();
  }
  
  public void EnableButtons()
  {
    CalculateButton.setText("Click where to place contacts of the element");
    CalculateButton.setEnabled(false);
    elementPanel.EnableButtons();
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if("calculate".equals(e.getActionCommand()))
    {
      Calculator.calculate();
    }
    if("power".equals(e.getActionCommand()))
    {
      DisableButtons();
      PowerSupply power = new PowerSupply();
      array.add(power);
      drawPanel.addMouseListener(power);
      while(power.isPlaced() != true) ;
      drawPanel.removeMouseListener(power);
      power.Draw();
      EnableButtons();
    }
    if("inductance".equals(e.getActionCommand()))
    {
      DisableButtons();
      Inductance inductance = new Inductance();
      array.add(inductance);
      drawPanel.addMouseListener(inductance);
      while(inductance.isPlaced() != true) ;
      drawPanel.removeMouseListener(inductance);
      inductance.Draw();
      EnableButtons();
    }
    if("capacity".equals(e.getActionCommand()))
    {
      DisableButtons();
      Capacity capacity = new Capacity();
      array.add(capacity);
      drawPanel.addMouseListener(capacity);
      while(capacity.isPlaced() != true) ;
      drawPanel.removeMouseListener(capacity);
      capacity.Draw();
      EnableButtons();
    }
    if("resistance".equals(e.getActionCommand()))
    {
      DisableButtons();
      Resistance resistance = new Resistance();
      array.add(resistance);
      drawPanel.addMouseListener(resistance);
      while(resistance.isPlaced() != true) ;
      drawPanel.removeMouseListener(resistance);
      resistance.Draw();
      EnableButtons();
    }
  }
  
  static final int DEFAULT_WIDTH = 640;
  static final int DEFAULT_HEIGHT = 480;
  
  private FrameButton CalculateButton;
  private ElementsPanel elementPanel;
  private DrawPanel drawPanel;
  private  ArrayList<Element> array;
}