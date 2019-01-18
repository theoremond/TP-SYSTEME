public class main {
    public static void main(String[] args) {
        Patisserie patisserie = new Patisserie();
        Patissier patissier = new Patissier(patisserie);
        Client client = new Client(patisserie);
        new Thread(client).start();
        new Thread(patissier).start();
    }
}
