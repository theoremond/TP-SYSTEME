public class Client implements Runnable{
    private Patisserie patisserie;

    public Client(Patisserie patisserie) {
        this.patisserie = patisserie;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while(true) patisserie.achete();
    }
}
