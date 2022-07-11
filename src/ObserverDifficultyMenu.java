import javax.swing.*;
import java.awt.*;

public class ObserverDifficultyMenu extends ObserverAbstract{

    public ObserverDifficultyMenu(ObserverSubject observerSubject){
        this.observerSubject = observerSubject;
        this.observerSubject.attach(this);
    }
    @Override
    public void displayFrame() {
        aardvarkSelectDifficulty.setLayout(new GridLayout(0, 1));
        button = new JButton("Simples");
        aardvarkSelectDifficulty.add(button);
        button.addActionListener(this);
        button = new JButton("Not-so-simples");
        aardvarkSelectDifficulty.add(button);
        button.addActionListener(this);
        button = new JButton("Super-duper-shuffled");
        aardvarkSelectDifficulty.add(button);
        button.addActionListener(this);
        aardvarkSelectDifficulty.pack();
        aardvark = new Aardvark(level);
    }
}






