package inghetata_decorator;

public class SiropDeCoacaze extends ToppingDecorator{

    public SiropDeCoacaze(Inghetata inghetata) {
        super(inghetata);
        System.out.println("adaug sirop de coacaze");
    }

    @Override
    public String descriere() {
        return tempInghetata.descriere() + ", sirop de coacaze";
    }

    @Override
    public double cost() {
        return tempInghetata.cost() + 0.60;
    }
}
