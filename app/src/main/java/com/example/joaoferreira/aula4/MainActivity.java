package com.example.joaoferreira.aula4;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends Activity implements View.OnKeyListener {
    EditText numeros;
    TextView msg;
    int sorteio;
    ListView listas;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = (TextView) findViewById(R.id.mensagem);
        numeros = (EditText) findViewById(R.id.numero);
        numeros.setOnKeyListener(this);
        sorteio = (int)(Math.random()*101);
    }
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() != KeyEvent.ACTION_DOWN){
            verificaPalpite();
            return true;
        }
        return false;
    }
    private void verificaPalpite() {
        int chute = Integer.parseInt(numeros.getText().toString());
        if(chute == sorteio)
            msg.setText("Acertou");
        else if(chute > sorteio)
            msg.setText("Tente um número menor");
        else
            msg.setText("Tente um número maior");
    }
}
