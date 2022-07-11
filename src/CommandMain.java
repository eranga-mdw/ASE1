public class CommandMain {
    public static void main(String args[]){
        Aardvark aardvark = new Aardvark();

        CommandPlaceDomino aardvarkPlaceDominoCommand = new CommandPlaceDomino(aardvark);

        CommandInvoker aardvarkCommandInvoker = new CommandInvoker(aardvarkPlaceDominoCommand);
        aardvarkCommandInvoker.forwardGame();

        System.out.println("Do you need to undo(Y : yes, N : no) :");
        String undo = IOLibrary.getString();
        if(undo.equalsIgnoreCase("Y")) {
            aardvarkCommandInvoker.backwardGame();
        }
    }
}



