package br.blog.fbastos.vetcalc;

/**
 * Created by fe_000 on 22/03/2016.
 */
public class Animal {

    private String especie;
    private ValorMinMax gestacao;
    private ValorMinMax fc;
    private ValorMinMax fr;
    private ValorMinMax temp;

    public ValorMinMax getGestacao() {
        return gestacao;
    }

    public void setGestacao(ValorMinMax gestacao) {
        this.gestacao = gestacao;
    }

    public ValorMinMax getFc() {
        return fc;
    }

    public void setFc(ValorMinMax fc) {
        this.fc = fc;
    }

    public ValorMinMax getFr() {
        return fr;
    }

    public void setFr(ValorMinMax fr) {
        this.fr = fr;
    }

    public ValorMinMax getTemp() {
        return temp;
    }

    public void setTemp(ValorMinMax temp) {
        this.temp = temp;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
