import java.awt.event.*;
import javax.swing.*;

class MainFrame extends JFrame
{
  public MainFrame()
  {
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Impedance Calculator");
    this.setVisible(true);

    ElementsPanel elementPanel = new ElementsPanel(this);
    this.setContentPane(elementPanel);

    DrawPanel schemaPanel = new DrawPanel(this);
    this.setContentPane(schemaPanel);

    FrameButton CalculateButton = new FrameButton("Calculate");
    CalculateButton.setVerticalTextPosition(AbstractButton.CENTER);
    CalculateButton.setHorizontalTextPosition(AbstractButton.LEADING);
    CalculateButton.setActionCommand("calculate");  
    this.getContentPane().add(CalculateButton);
  }
 
  static final int DEFAULT_WIDTH = 640;
  static final int DEFAULT_HEIGHT = 480;
}