package thiago.cury.aula9spinner;

/**
 * Created by Alunos on 12/12/2016.
 */

public class Cliente {

    private String nome;
    private String estadoCivil;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
}//fecha classe
