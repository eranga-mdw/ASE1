public class AutoPlayer03 implements Strategy{
    @Override
    public void autoPlay() {
        Aardvark aardvark = new Aardvark(3);
        aardvark.playerName = "Player 03";
        aardvark.play();
    }
}



