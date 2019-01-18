public class Patissier implements Runnable {

    private Patisserie patisserie;

    Patissier(Patisserie patisserie) {
        this.patisserie = patisserie;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            patisserie.depose();
        }

    }
}
