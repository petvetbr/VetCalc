package br.blog.fbastos.vetcalc;

/**
 * Created by fe_000 on 28/03/2016.
 */
public class Util {
    //    Note: body surface area (BSA) in square meters = K × (body wt in grams2/3) × 10-4
//    K = constant (10.1 for dogs and 10.0 for cats)
    public static double GetBodyAreaM2(Especies species, double pesoKg) {
        double area = 0;
        double K = 0;
        switch (species) {
            case CANINA:
                K = 10.1;
                break;
            case FELINA:
                K = 10;
                break;
            case EQUINA:
                break;
            case BOVINA:
                break;
            case OVINA:
                break;
            case CAPRINA:
                break;
            case SUINA:
                break;
        }
        area = K * Math.pow((pesoKg * 1000), (0.66666666666667)) * 0.0001;
        return area;
    }
}
