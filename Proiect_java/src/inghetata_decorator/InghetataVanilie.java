package inghetata_decorator;

public class InghetataVanilie extends Inghetata{
        String descriere="Inghetata de vanilie";
        Categorie categorie;
        InghetataVanilie(Categorie categorie){
            this.categorie=categorie;
        }

    @Override
    public String descriere() {
        return descriere;
    }

    @Override
    public double cost() {
        return 3;
    }
}
