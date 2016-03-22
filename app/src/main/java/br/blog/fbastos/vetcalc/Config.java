package br.blog.fbastos.vetcalc;

import java.util.HashMap;

/**
 * Created by fe_000 on 22/03/2016.
 */
public final class Config {

    private static HashMap<String, Animal> especies;

    public static HashMap<String, Animal> getEspecies() {
        if (especies == null) CriarEspecies();
        return especies;
    }

    private static void setEspecies(HashMap<String, Animal> especies) {
        Config.especies = especies;
    }

    private static void CriarEspecies() {

        Animal cao = new Animal();
        cao.setEspecie("Canina");
        cao.setGestacao(new ValorMinMax() {{
            setMax(65);
            setMin(59);
        }});

        Animal gato = new Animal();
        gato.setEspecie("Felina");
        gato.setGestacao(new ValorMinMax() {{
            setMin(60);
            setMax(70);
        }});
        Animal cavalo = new Animal();
        cavalo.setEspecie("Equina");
        cavalo.setGestacao(new ValorMinMax() {{
            setMin(315);
            setMax(370);
        }});
        Animal boi = new Animal();
        boi.setEspecie("Bovina");
        boi.setGestacao(new ValorMinMax() {{
            setMin(280);
            setMax(290);
        }});
        Animal ovelha = new Animal();
        ovelha.setEspecie("Ovina");
        ovelha.setGestacao(new ValorMinMax() {{
            setMin(142);
            setMax(152);
        }});
        Animal cabra = new Animal();
        cabra.setEspecie("Caprina");
        cabra.setGestacao(new ValorMinMax() {{
            setMin(145);
            setMax(155);
        }});
        Animal sui = new Animal();
        sui.setEspecie("Suína");
        sui.setGestacao(new ValorMinMax() {{
            setMin(112);
            setMax(114);
        }});
        setEspecies(new HashMap<String, Animal>());
        getEspecies().put(cao.getEspecie(), cao);
        getEspecies().put(gato.getEspecie(), gato);
        getEspecies().put(cavalo.getEspecie(), cavalo);
        getEspecies().put(boi.getEspecie(), boi);
        getEspecies().put(cabra.getEspecie(), cabra);
        getEspecies().put(ovelha.getEspecie(), ovelha);
        getEspecies().put(sui.getEspecie(), sui);
    }
}
