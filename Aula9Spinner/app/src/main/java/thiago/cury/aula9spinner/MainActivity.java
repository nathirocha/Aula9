package thiago.cury.aula9spinner;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widget
    private EditText etNome;
    private Spinner spEstado;
    private Button btnOK;
    private RelativeLayout layout;

    //Objeto
    private Cliente cli;

    //Log
    private static final String TAG_LOG = "LogsMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_LOG,"Entrou no onCreate");
        Log.d(TAG_LOG,"Vai passar pelas referencias");
        //Referencias
        etNome = (EditText) findViewById(R.id.ma_et_nome);
        spEstado = (Spinner) findViewById(R.id.ma_sp_estado);
        btnOK = (Button) findViewById(R.id.ma_btn_ok);
        layout = (RelativeLayout) findViewById(R.id.layout);
        Log.d(TAG_LOG,"Passou pelas referencias");

        AdapterView.OnItemSelectedListener selected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (spEstado.getSelectedItem().toString()){
                    case "Solteiro":
                        layout.setBackgroundResource(R.drawable.jupiter);
                        break;
                    case "Casado":
                        layout.setBackgroundResource(R.drawable.marte);
                        break;
                    case "Divorciado":
                        layout.setBackgroundResource(R.drawable.mercurio);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        //Inserir ouvidor(listener) na Spinner
        spEstado.setOnItemSelectedListener(selected);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spEstado.getSelectedItem().toString().equalsIgnoreCase("Selecione")) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("Selecione um estado civil pfv!");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK",null);
                    msg.show();
                }else if(!Validacao.testarNome(etNome.getText().toString())) {
                    AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                    msg.setTitle("ERRO");
                    msg.setMessage("Nome INVALIDO");
                    msg.setIcon(R.mipmap.ic_launcher);
                    msg.setNeutralButton("OK", null);
                    msg.show();
                }else{
                    cli = new Cliente();
                    cli.setNome(etNome.getText().toString());
                    cli.setEstadoCivil(spEstado.getSelectedItem().toString());
                    Toast.makeText(
                            getBaseContext(),
                            cli.toString(),
                            Toast.LENGTH_LONG).show();
                    limpar();
                }
            }//fecha onClick
        });
    }//fecha onCreate

    private void limpar(){
        etNome.setText(null);
        spEstado.setSelection(0);
    }
}//fecha main
