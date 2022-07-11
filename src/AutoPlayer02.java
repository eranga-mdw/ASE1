public class AutoPlayer02 implements Strategy{
    @Override
    public void autoPlay() {
        Aardvark aardvark = new Aardvark(2);
        aardvark.playerName = "Player 02";
        aardvark.play();
    }
}



