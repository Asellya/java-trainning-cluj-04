package inghetata_decorator;

public class InghetataMenta extends Inghetata {
    private String descriere="Inghetata cu menta";
    private Categorie categorie;
    InghetataMenta(Categorie categorie){
        this.categorie=categorie;
    }

    @Override
    public String descriere() {
        return descriere;
    }

    @Override
    public double cost() {
        return 3.50;
    }
}
