package inghetata_decorator;

public class Piscot extends ToppingDecorator {

    public Piscot(Inghetata inghetata) {
        super(inghetata);
        System.out.println("adaug piscot");
    }

    @Override
    public String descriere() {
        return tempInghetata.descriere() + ", piscot";
    }

    @Override
    public double cost() {
        return tempInghetata.cost() + 1;
    }
}
