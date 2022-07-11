public class ContextStrategy {
    public Strategy strategy;

    public ContextStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.autoPlay();
    }
}



