package inghetata_decorator;

public class InghetataCaramel extends Inghetata{
    private String descriere="Inghetata cu caramel";
    private Categorie categorie;
    InghetataCaramel(Categorie categorie){
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
