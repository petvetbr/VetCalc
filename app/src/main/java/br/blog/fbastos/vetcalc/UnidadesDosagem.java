package br.blog.fbastos.vetcalc;

/**
 * Created by fe_000 on 28/03/2016.
 */
public enum UnidadesDosagem {
    MG_Kg(0),
    MG_M2_CANINO(1),
    MG_M2_FELINA(2);


    private int codigo;

    UnidadesDosagem(int cod) {
        setCodigo(cod);
    }

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
