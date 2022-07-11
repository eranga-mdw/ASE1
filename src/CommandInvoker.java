public class CommandInvoker {
    private CommandInterface placeDomino;

    public CommandInvoker(CommandPlaceDomino aardvarkPlaceDominoCommand){
        this.placeDomino = aardvarkPlaceDominoCommand;
    }

    public void forwardGame(){
        placeDomino.playGame();
    }

    public void backwardGame(){
        placeDomino.undoGame();
    }
}



