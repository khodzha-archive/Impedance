class Resistance extends Element
{
  public Resistance()
  {
    String str = JOptionPane.showInputDialog("Enter resistance value");
    NumberFormat fmt = NumberFormat.getInstance();
    Number num = fmt.parse(str);
    double resistance = num.doubleValue();
  }

  private double resistance;
}