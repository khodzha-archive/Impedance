class NewThread implements Runnable
{
  NewThread(MainFrame fr,Element elem)
  { 
    this.element = elem;
    this.frame = fr;
    thread = new Thread(this); 
    thread.start(); 
  }
  
  public void run()
  {
      while(element.isPlaced() != true)
        ;
      frame.delMouseListener(element);
      element.Draw(frame.getdrawPanel().getGraphics());
      frame.EnableButtons();
  }
  
  private Thread thread;
  private Element element;
  private MainFrame frame;
}