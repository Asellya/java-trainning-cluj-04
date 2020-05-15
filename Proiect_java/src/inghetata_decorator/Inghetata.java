package inghetata_decorator;
/*clasa Inghetata este caracterizata de o descriere si o categorie, o functie care trebuie sa calculeze costul inghetatei si
* o functie care sa afiseze descrierea inghetatei*/

//puteam folosi si interfata Inghetata dar atunci toate metodele ar fi fost abstracte
//asa ca am ales ca folosesc clasa abstracta pentru ca imi permite sa definesc atat metode abstracte cat si clar definite

public abstract class Inghetata {
    private String descriere;
    private Categorie categorie;
    public abstract double cost();
    public String descriere(){
        return descriere;
    }
}

/*Vom avea 4 tipuri de inghetata (vanilie - 3 lei, ciocolata - 3.20, cu menta 3.50, cu caramel - 3.50) cu diferite preturi de baza.
 Pentru a imbogati si decora orice tip de inghetata, se pot cere toppinguri speciale (alune -0.80,fulgi ciocolata -0.90,piscot - 1
 sau sirop de coacaze -0.60. )*/
/*Fiecare tip de inghetata va suprascrie functia care permite calcularea costului totial in functie de tipul inghetatei
* si de topping-urile adaugate. Prin functia de descriere fiecare tip de inchetata va afisa pe ecran tipul acesteia
* si lista de toppinguri adaugate*/