package ProduseBIO_FactoryDP;

public class SalataBio extends ProdusBIO {
   SalataBio(){
        setPretProductie(10);
        setRabat(0.2);
    }

    @Override
    public double calculeazaPretVanzare(double pretProductie, double rabat) {
        double pretVanzare = pretProductie - pretProductie * rabat;
        return pretVanzare;

    }

}
