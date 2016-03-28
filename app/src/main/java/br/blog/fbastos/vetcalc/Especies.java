package br.blog.fbastos.vetcalc;

/**
 * Created by fe_000 on 28/03/2016.
 */
public enum Especies {
    CANINA(0),
    FELINA(1),
    EQUINA(2),
    BOVINA(3),
    OVINA(4),
    CAPRINA(5),
    SUINA(6);

    private int codigo;

    Especies(int cod) {
        this.setCodigo(cod);
    }

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
