import javax.swing.*;

class ElementsPanel extends JPanel
{
  public ElementsPanel(MainFrame frame)
  {
    this.PowerSupplyButton = new FrameButton("Power Supply");
    this.PowerSupplyButton.setActionCommand("power");
    this.add(this.PowerSupplyButton);
    this.PowerSupplyButton.addActionListener(frame);

    this.ResistanceButton = new FrameButton("Resistance");
    this.ResistanceButton.setActionCommand("resistance");
    this.add(this.ResistanceButton);
    this.ResistanceButton.addActionListener(frame);

    this.InductanceButton = new FrameButton("Inductance");
    this.InductanceButton.setActionCommand("inductance");
    this.add(this.InductanceButton);
    this.InductanceButton.addActionListener(frame);

    this.CapacityButton = new FrameButton("Capacity");
    this.CapacityButton.setActionCommand("capacity");
    this.add(this.CapacityButton);
    this.CapacityButton.addActionListener(frame);
  }
  public ElementsPanel()
  {
  }
  
  public void DisableButtons()
  {
    PowerSupplyButton.setEnabled(false);
    CapacityButton.setEnabled(false);
    ResistanceButton.setEnabled(false);
    InductanceButton.setEnabled(false);
  }
  
  public void EnableButtons()
  {
    PowerSupplyButton.setEnabled(true);
    CapacityButton.setEnabled(true);
    ResistanceButton.setEnabled(true);
    InductanceButton.setEnabled(true);
  }
  
  private FrameButton PowerSupplyButton;
  private FrameButton CapacityButton;
  private FrameButton ResistanceButton;
  private FrameButton InductanceButton;
}