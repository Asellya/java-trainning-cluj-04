package inghetata_decorator;

public class Alune extends ToppingDecorator {

    public Alune(Inghetata inghetata) {
        super(inghetata);
        System.out.println("Adaug alune");
    }
    @Override
    public String descriere() {
        return tempInghetata.descriere() + ", alune";
    }

    @Override
    public double cost() {
        return tempInghetata.cost() + 0.80;
    }
}
