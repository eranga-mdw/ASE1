public class AutoPlayer01 implements Strategy{
    @Override
    public void autoPlay() {
        Aardvark aardvark = new Aardvark(1);
        aardvark.playerName = "Player 01";
        aardvark.play();
    }
}




