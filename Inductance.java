class Inductance extends Element
{
  public Inductance()
  {
    String str = JOptionPane.showInputDialog("Enter inductance value");
    NumberFormat fmt = NumberFormat.getInstance();
    Number num = fmt.parse(str);
    double inductance = num.doubleValue();
  }

  private double inductance;
}