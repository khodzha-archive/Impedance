import javax.swing.*;

class ElementsPanel extends JPanel
{
  public ElementsPanel()
  {
    this.PowerSupplyButton = new FrameButton("Power Supply");
    this.PowerSupplyButton.setActionCommand("power");
    this.add(PowerSupplyButton);
    this.ResistanceButton = new FrameButton("Resistance");
    this.ResistanceButton.setActionCommand("resistance");
    this.add(ResistanceButton);
    this.InductanceButton = new FrameButton("Inductance");
    this.InductanceButton.setActionCommand("inductance");
    this.add(InductanceButton);
    this.CapacityButton = new FrameButton("Capacity");
    this.CapacityButton.setActionCommand("capacity");
    this.add(CapacityButton);
  }
  
  public void DisableButtons()
  {
    PowerSupplyButton.setEnabled(false);
    CapacityButton.setEnabled(false);
    ResistanceButton.setEnabled(false);
    InductanceButton.setEnabled(false);
  }
  
  private FrameButton PowerSupplyButton;
  private FrameButton CapacityButton;
  private FrameButton ResistanceButton;
  private FrameButton InductanceButton;
}