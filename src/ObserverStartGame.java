import javax.swing.*;
import java.awt.*;


public class ObserverStartGame extends ObserverAbstract{

    public ObserverStartGame(ObserverSubject observerSubject){
        this.observerSubject = observerSubject;
        this.observerSubject.attach(this);
    }
    @Override
    public void displayFrame() {
        aardvarkMainGUI.setLayout(new GridLayout(0, 1));
        label = new JLabel(" Welcome to Abominodo - The Best Dominoes Puzzle Game ");
        aardvarkMainGUI.add(label);
        label = new JLabel(" Version 1.0 (c), Kevan Buckley, 2010");
        aardvarkMainGUI.add(label);
        aardvarkMainGUI.pack();
        aardvarkMainGUI.setVisible(true);
    }
}





