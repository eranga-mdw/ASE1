public class MVCView {
    public void MVCMainGUI() {
        ObserverSubject observerSubject = new ObserverSubject();

        new ObserverStartGame(observerSubject);
        new ObserverPlayer(observerSubject);
        new ObserverMainMenu(observerSubject);
        new ObserverDifficultyMenu(observerSubject);

        observerSubject.notifyAllObservers();
    }
}



