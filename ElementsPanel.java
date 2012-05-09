import javax.swing.*;

class ElementsPanel extends JPanel
{
  public ElementsPanel()
  {
    FrameButton PowerSupplyButton = new FrameButton("Power Supply");
    PowerSupplyButton.setActionCommand("power");
    this.add(PowerSupplyButton);
    FrameButton ResistanceButton = new FrameButton("Resistance");
    ResistanceButton.setActionCommand("resistance");
    this.add(ResistanceButton);
    FrameButton InductanceButton = new FrameButton("Inductance");
    InductanceButton.setActionCommand("inductance");
    this.add(InductanceButton);
    FrameButton CapacityButton = new FrameButton("Capacity");
    CapacityButton.setActionCommand("capacity");
    this.add(CapacityButton);
  }
}