package inghetata_decorator;

abstract class ToppingDecorator extends Inghetata {
    protected Inghetata tempInghetata;
    public ToppingDecorator(Inghetata inghetata){
        tempInghetata=inghetata;
    }

    @Override
    public String descriere() {
        return tempInghetata.descriere();
    }

    @Override
    public double cost() {
        return tempInghetata.cost();
    }
}
