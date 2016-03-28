package br.blog.fbastos.vetcalc;

/**
 * Created by fe_000 on 28/03/2016.
 */
public enum Medidas {
    MG_COMP(0),
    MG_ML(1),
    PERCENT(2);

    private int codigo;

    Medidas(int cod) {
        setCodigo(cod);
    }


    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
