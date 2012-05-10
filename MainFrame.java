import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MainFrame extends JFrame implements ActionListener
{
  public MainFrame()
  {
    super("Impedance Calculator");
    this.array = new ArrayList<Element>();
    this.CalculateButton = new FrameButton("Calculate");
    this.elementPanel = new ElementsPanel(this);

    this.textField = new JTextField();
    textField.setVisible(false);
    
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    JPanel buttonsPanel = new JPanel(new FlowLayout());
    buttonsPanel.add(CalculateButton);
    buttonsPanel.add(textField);
    textField.setEditable(false);
    add(buttonsPanel, BorderLayout.SOUTH);

    this.CalculateButton.setVerticalTextPosition(AbstractButton.CENTER);
    this.CalculateButton.setHorizontalTextPosition(AbstractButton.LEADING);
    this.CalculateButton.setActionCommand("calculate");
    this.CalculateButton.addActionListener(this);

    add(this.elementPanel, BorderLayout.NORTH);

    this.drawPanel = new DrawPanel();
    add(this.drawPanel, BorderLayout.CENTER);
  }

  public DrawPanel getdrawPanel() { return this.drawPanel; }
  public ArrayList<Element> getElements() { return this.array; }
  
  public void DisableButtons()
  {
    CalculateButton.setText("Click where to place contacts of the element");
    CalculateButton.setEnabled(false);
    elementPanel.DisableButtons();
  }
  
  public void delMouseListener(Element element)
  {
    drawPanel.removeMouseListener(element);
  }
  
  public void EnableButtons()
  {
    CalculateButton.setText("Calculate");
    CalculateButton.setEnabled(true);
    elementPanel.EnableButtons();
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if("calculate".equals(e.getActionCommand()))
    {
      if(this.check() == true)
      {
        this.calculate();
      }
      else
      {
        textField.setVisible(true);
      }
    }
    if("power".equals(e.getActionCommand()))
    {
      DisableButtons();
      PowerSupply power = new PowerSupply();
      array.add(power);
      drawPanel.addMouseListener(power);
      new NewThread(this, power);
    }
    if("inductance".equals(e.getActionCommand()))
    {
      DisableButtons();
      Inductance inductance = new Inductance();
      array.add(inductance);
      drawPanel.addMouseListener(inductance);
      new NewThread(this, inductance);
    }
    if("capacity".equals(e.getActionCommand()))
    {
      DisableButtons();
      Capacity capacity = new Capacity();
      array.add(capacity);
      drawPanel.addMouseListener(capacity);
      new NewThread(this, capacity);
    }
    if("resistance".equals(e.getActionCommand()))
    {
      DisableButtons();
      Resistance resistance = new Resistance();
      array.add(resistance);
      drawPanel.addMouseListener(resistance);
      new NewThread(this, resistance);
    }
  }
  
  public boolean check()
  {
//TODO check chain
    boolean withPowerSupply = false;
    for(Element elem : array)
    {
      for(Element comparison : array)
      {
        if( comparison != elem )
        {
          if((Math.pow((elem.getfirstX()-comparison.getfirstX()),2) + Math.pow((elem.getfirstY()-comparison.getfirstY()),2)) < 25 ||
            (Math.pow((elem.getfirstX()-comparison.getsecondX()),2) + Math.pow((elem.getfirstY()-comparison.getsecondY()),2)) < 25)
          {
            elem.setfirstContact(true);
          }
          if((Math.pow((elem.getsecondX()-comparison.getfirstX()),2) + Math.pow((elem.getsecondY()-comparison.getfirstY()),2)) < 25 ||
            (Math.pow((elem.getsecondX()-comparison.getsecondX()),2) + Math.pow((elem.getsecondY()-comparison.getsecondY()),2)) < 25)
          {
            elem.setsecondContact(true);
          }
        }
      }
      if(elem.getfirstContact() == false || elem.getsecondContact() == false)
      {
        this.textField.setText("Chain is broken");
        return false;
      }
      if(true/*SET CONDITION  Element.type == PowerSupply*/)
      {
        withPowerSupply = true;
      }
    }
    if(withPowerSupply == false)
      {
        this.textField.setText("No PowerSupply");
        return false;
      }
    return true;
  }
    
  public void calculate()
  {
//TODO calculation
    
  }
  
  static final int DEFAULT_WIDTH = 640;
  static final int DEFAULT_HEIGHT = 480;
  
  private JTextField textField;
  private FrameButton CalculateButton;
  private ElementsPanel elementPanel;
  private DrawPanel drawPanel;
  private  ArrayList<Element> array;
}