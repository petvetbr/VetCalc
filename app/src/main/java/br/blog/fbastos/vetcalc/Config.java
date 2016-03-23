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
        cao.setFc(new ValorMinMax() {{
            setMin(70);
            setMax(160);
        }});
        cao.setFr(new ValorMinMax() {{
            setMax(20);
            setMin(10);
        }});
        cao.setTemp(new ValorMinMax() {{
            setMin(38);
            setMax(39.2);
        }});


        Animal gato = new Animal();
        gato.setEspecie("Felina");
        gato.setGestacao(new ValorMinMax() {{
            setMin(60);
            setMax(70);
        }});
        gato.setFc(new ValorMinMax() {{
            setMin(160);
            setMax(240);
        }});
        gato.setFr(new ValorMinMax() {{
            setMin(26);
            setMax(30);
        }});
        gato.setTemp(new ValorMinMax() {{
            setMin(37.8);
            setMax(39.4);
        }});



        Animal cavalo = new Animal();
        cavalo.setEspecie("Equina");
        cavalo.setGestacao(new ValorMinMax() {{
            setMin(315);
            setMax(370);
        }});

        cavalo.setFc(new ValorMinMax() {{
            setMin(28);
            setMax(40);
        }});
        cavalo.setFr(new ValorMinMax() {{
            setMin(10);
            setMax(14);
        }});
        cavalo.setTemp(new ValorMinMax() {{
            setMin(37.2);
            setMax(38.3);
        }});

        Animal boi = new Animal();
        boi.setEspecie("Bovina");
        boi.setGestacao(new ValorMinMax() {{
            setMin(280);
            setMax(290);
        }});

        boi.setFc(new ValorMinMax() {{
            setMin(48);
            setMax(84);
        }});
        boi.setFr(new ValorMinMax() {{
            setMin(26);
            setMax(50);
        }});
        boi.setTemp(new ValorMinMax() {{
            setMin(37.2);
            setMax(38.3);
        }});


        Animal ovelha = new Animal();
        ovelha.setEspecie("Ovina");
        ovelha.setGestacao(new ValorMinMax() {{
            setMin(142);
            setMax(152);
        }});

        ovelha.setFc(new ValorMinMax() {{
            setMin(70);
            setMax(80);
        }});
        ovelha.setFr(new ValorMinMax() {{
            setMin(16);
            setMax(34);
        }});
        ovelha.setTemp(new ValorMinMax() {{
            setMin(38.3);
            setMax(39.4);
        }});

        Animal cabra = new Animal();
        cabra.setEspecie("Caprina");
        cabra.setGestacao(new ValorMinMax() {{
            setMin(145);
            setMax(155);
        }});

        cabra.setFc(new ValorMinMax() {{
            setMin(70);
            setMax(80);
        }});
        cabra.setFr(new ValorMinMax() {{
            setMin(10);
            setMax(16);
        }});
        cabra.setTemp(new ValorMinMax() {{
            setMin(38.2);
            setMax(40.7);
        }});

        Animal sui = new Animal();
        sui.setEspecie("Suína");
        sui.setGestacao(new ValorMinMax() {{
            setMin(112);
            setMax(114);
        }});

        sui.setFc(new ValorMinMax() {{
            setMin(70);
            setMax(120);
        }});
        sui.setFr(new ValorMinMax() {{
            setMin(8);
            setMax(18);
        }});
        sui.setTemp(new ValorMinMax() {{
            setMin(38);
            setMax(39.5);
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
