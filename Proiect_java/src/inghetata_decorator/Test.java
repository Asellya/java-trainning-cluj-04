package inghetata_decorator;

public class Test {

    public static void main(String[] args) {
        Inghetata inghetata = new Alune(new InghetataCaramel(Categorie.standard));
        System.out.println("Ingrediente: " +inghetata.descriere());
        System.out.println("Pret: " +inghetata.cost());

        Inghetata inghetata1 = new Piscot(new FulgiDeCiocolata(new InghetataMenta(Categorie.gourmet)));
        System.out.println("Ingrediente: " +inghetata1.descriere());
        System.out.println("Pret: " +inghetata1.cost());

        Inghetata inghetata2 = new Piscot(new Alune(new SiropDeCoacaze(new FulgiDeCiocolata(new InghetataVanilie(Categorie.fara_zahar)))));
        System.out.println("Ingrediente: " +inghetata2.descriere());
        System.out.println("Pret: " +inghetata2.cost());
    }
}
