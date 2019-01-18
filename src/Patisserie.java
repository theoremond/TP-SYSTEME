import java.util.ArrayList;

class Patisserie {
    private ArrayList<Gateau> stock;

    Patisserie() {
        this.stock = new ArrayList<>();
    }

    synchronized void depose() {
        this.stock.add(new Gateau());
        System.out.println("Gateau fabriqué !");
        if (getstock() >= 1) {
            this.notify();
        }
    }

    synchronized void achete() {
        while (getstock() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        Gateau gateauAchete = this.stock.get(0);
        this.stock.remove(gateauAchete);
        System.out.println("Gateau acheté !");
    }

    private int getstock() {
        return this.stock.size();
    }
}
