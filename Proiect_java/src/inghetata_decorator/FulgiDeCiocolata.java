package inghetata_decorator;

public class FulgiDeCiocolata extends ToppingDecorator {
    public FulgiDeCiocolata(Inghetata inghetata) {
        super(inghetata);
        System.out.println("adaug fulgi de ciocolata");
    }
    @Override
    public String descriere() {
        return tempInghetata.descriere() + ", fulgi de ciocolata";
    }

    @Override
    public double cost() {
        return tempInghetata.cost() + 0.90;
    }
}
