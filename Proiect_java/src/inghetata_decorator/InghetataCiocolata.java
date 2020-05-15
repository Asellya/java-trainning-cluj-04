package inghetata_decorator;

public class InghetataCiocolata extends Inghetata {
    private String descriere="Inghetata de ciocolata";
    private Categorie categorie;
    InghetataCiocolata(Categorie categorie){
        this.categorie=categorie;
    }
    @Override
    public String descriere() {
        return descriere;
    }
    @Override
    public double cost() {
        return 3.20;
    }
}
