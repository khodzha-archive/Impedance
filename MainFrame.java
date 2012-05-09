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
    this.elementPanel = new ElementsPanel();

    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    JPanel buttonsPanel = new JPanel(new FlowLayout());
    buttonsPanel.add(CalculateButton);
    add(buttonsPanel, BorderLayout.SOUTH);

    this.CalculateButton.setVerticalTextPosition(AbstractButton.CENTER);
    this.CalculateButton.setHorizontalTextPosition(AbstractButton.LEADING);
    this.CalculateButton.setActionCommand("calculate");

    add(elementPanel, BorderLayout.NORTH);

    drawPanel = new DrawPanel();
    add(drawPanel, BorderLayout.CENTER);
  }

  public void DisableButtons()
  {
    CalculateButton.setText("Click where to place contacts of the element");
    CalculateButton.setEnabled(false);
    elementPanel.DisableButtons();
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
      DrawPanel.addMouseListener();
      PowerSupply power = new PowerSupply();
      array.add(power);
    }
    if("inductance".equals(e.getActionCommand()))
    {
      DisableButtons();
      DrawPanel.addMouseListener();
      Inductance inductance = new Inductance();
      array.add(inductance);
    }
    if("capacity".equals(e.getActionCommand()))
    {
      DisableButtons();
      DrawPanel.addMouseListener();
      Capacity capacity = new Capacity();
      array.add(capacity);
    }
    if("resistance".equals(e.getActionCommand()))
    {
      DisableButtons();
      DrawPanel.addMouseListener();
      Resistance resistance = new Resistance();
      array.add(resistance);
    }
  }
  
  static final int DEFAULT_WIDTH = 640;
  static final int DEFAULT_HEIGHT = 480;
  
  private FrameButton CalculateButton;
  private ElementsPanel elementPanel;
  private DrawPanel drawPanel;
  private  ArrayList<Element> array;
}