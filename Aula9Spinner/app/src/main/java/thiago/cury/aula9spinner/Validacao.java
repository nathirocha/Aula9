package thiago.cury.aula9spinner;

/**
 * Created by Alunos on 12/12/2016.
 */

public class Validacao {
    public static boolean testarNome(String nome){
        return nome.matches("^[a-z]{2,50}$");
    }
}
