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
    
    total_impedance = new Complex(0.0, 0.0);
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
        this.updateImpedance();
        this.organize();
        this.calculate();
        textField.setVisible(true);
        System.out.println("\n\n-----------------------------------------------------\nTotal impedance:\n");
        System.out.println(this.total_impedance.toString());
        textField.setText(this.total_impedance.toString());
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
  
  public void updateImpedance()
  {
    double frequency = ((PowerSupply)array.get(power_element_index)).getFrequency();
    for(Element elem : array)
    {
      if(elem.getClass().getName().equals("Capacity"))
      {
        Complex num =new Complex();
        num.setRe(elem.getImpedance().getRe());
        num.setIm(elem.getImpedance().getIm() * (1.0/frequency));
        elem.setImpedance(num);
      }
       if(elem.getClass().getName().equals("Inductance"))
      {
        Complex num =new Complex();
        num.setRe(elem.getImpedance().getRe());
        num.setIm(elem.getImpedance().getIm() * frequency);
        elem.setImpedance(num);
      }
    }
  }
  
  public boolean check()
  {
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
            elem.addNewConnection(comparison, "first");
          }
          if((Math.pow((elem.getsecondX()-comparison.getfirstX()),2) + Math.pow((elem.getsecondY()-comparison.getfirstY()),2)) < 25 ||
            (Math.pow((elem.getsecondX()-comparison.getsecondX()),2) + Math.pow((elem.getsecondY()-comparison.getsecondY()),2)) < 25)
          {
            elem.setsecondContact(true);
            elem.addNewConnection(comparison, "second");
          }
        }
      }
      if(elem.getfirstContact() == false || elem.getsecondContact() == false)
      {
        this.textField.setText("Chain is broken");
        return false;
      }
      if(elem.getClass().getName().equals("PowerSupply"))
      {
        power_element_index = array.indexOf(elem);
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
  
  public void organize()
  {
    Collections.swap(array, 0, power_element_index);
    array.get(power_element_index).swapContacts();
    for(Element element : array)
    {
      for(Element elem : element.getConnections("second"))
      {
        if(elem.getConnections("second").indexOf(element) != -1 && elem.getConnections("first").indexOf(element) == -1 && elem != array.get(power_element_index))
        {
          elem.swapContacts();
        }
      }
    }
  }
    
  public void calculate()
  {
    double frequency = ((PowerSupply)array.get(power_element_index)).getFrequency();
    while(array.size()>2)
    {
      System.out.println(Integer.toString(array.size()));
      simplify();
    }
    sumFinalImpedance();
  }
  
  public void simplify()
  {
top:for(Element elem1 : array)
    {
      for(Element elem2 : array)
      {
      if(elem1 != elem2 && elem1.getClass().getName().equals("PowerSupply") == false && elem2.getClass().getName().equals("PowerSupply") == false)
      {
          if(elem1.getConnections("first").indexOf(elem2) != -1 && elem1.getConnections("second").indexOf(elem2) != -1)
          {
            replaceParallel(elem1,elem2);
            break top;
          }
          else if(elem1.getConnections("second").indexOf(elem2) !=-1 && elem1.getConnections("second").size() == 1)
          {
            replaceSerial(elem1,elem2);
            break top;
          }
        }
      }
    }
  }
  
  public void replaceParallel(Element elem1, Element elem2)
  {
    Complex unit = new Complex (1, 0);
    Complex num1 = new Complex (1, 0);
    Complex num2 = new Complex (1, 0);
    num1 = num1.div(elem1.getImpedance());
    num2 = num2.div(elem2.getImpedance());
    num1 = num1.add(num2);
    num1 = unit.div(num1);
    elem1.setImpedance(num1);
    for(Element element : array)
    {
        if(element != elem2)
        {
            if(element.getConnections("left").indexOf(elem2) != -1)
                element.getConnections("left").remove(element.getConnections("left").indexOf(elem2));
            if(element.getConnections("right").indexOf(elem2) != -1)
                element.getConnections("right").remove(element.getConnections("right").indexOf(elem2));
        }
    }
    array.remove(array.indexOf(elem2));
  }
  
  public void replaceSerial(Element elem1, Element elem2)
  {
    elem1.setImpedance(elem1.getImpedance().add(elem2.getImpedance()));
    elem1.copyConnections(elem2);
    for(Element element : array)
    {
        if(element != elem1 && element !=elem2)
        {
            if(element.getConnections("left").indexOf(elem2) != -1)
            {
                element.getConnections("left").set(element.getConnections("left").indexOf(elem2), elem1);
            }
            if(element.getConnections("right").indexOf(elem2) != -1)
            {
                element.getConnections("right").set(element.getConnections("right").indexOf(elem2), elem1);
            }
        }
    }
    array.remove(array.indexOf(elem2));
  }
  
  public void sumFinalImpedance()
  {
    for(Element elem : array)
    {
      this.total_impedance = this.total_impedance.add(elem.getImpedance()) ;
    }
  }
  
  static final int DEFAULT_WIDTH = 640;
  static final int DEFAULT_HEIGHT = 480;
  
  private JTextField textField;
  private FrameButton CalculateButton;
  private ElementsPanel elementPanel;
  private DrawPanel drawPanel;
  private  ArrayList<Element> array;
  private int power_element_index;
  private Complex total_impedance;
}
