package ProduseBIO_FactoryDP;
/*Am definit produs bio ca si clasa abstracta. Din nou se putea folosi interfata dar am ales sa definesc explicit
* majoritatea metodelor pentru a putea utiliza codul fara fi nevoie sa il rescriu in fiecare clasa.
* as fi putut defini explicit toate metodele dar am ales sa fac o metoda abstracta pentru a subilina ca pot folosi
* atat metode abstracte cat si clar definite in cadrul unei clase abstracte comparativ cu o interfata unde cum am precizat
* toate metodele sunt implicit abstracte
* Fiecare produs va avea un pret si un rabat comercial stabilit in fiecare clasa. In functie de pretul de productie
* si de rabatul comercial vom calcula pretul de vanzare*/
/*Am facut doua clase iaurt bio si salata bio care mostenesc clasa abstracta produs bio si am stabilit pentru fiecare produs
* pretul de productie si rabatul comercial si am implementat metoda care calculeaza pretul de vanzare al produsului. */

public abstract class ProdusBIO {

    public double pretProductie;
    public double rabatComercial;

    public void setPretProductie(double pret) {pretProductie=pret;}
    public double getPretProductie() {return pretProductie;}

    public void setRabat(double rabat){rabatComercial=rabat;}
    public double getRabat(){return rabatComercial;}

    public abstract double calculeazaPretVanzare(double pretProductie, double rabat);

}
