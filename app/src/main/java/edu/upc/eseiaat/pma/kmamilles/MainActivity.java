package edu.upc.eseiaat.pma.kmamilles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para hacer referencia a los obejtos del layout.//
        Button btn_m = (Button) findViewById(R.id.btn_m);
        Button btn_km = (Button) findViewById(R.id.btn_km);


        //Se pone el final conforme no se va  acambiar el valor.//
        final EditText text_km = (EditText) findViewById (R.id.text_km);
        final EditText text_m = (EditText) findViewById (R.id.text_m);


        //Haig de posar aquest text per poder configurar, i anar amb compte de que no estigui en permanent bucle.
        //text_m.addTextChangedListener(new TextWatcher() {
          //  @Override
            //public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            //}

            //@Override
            //public void onTextChanged(CharSequence s, int start, int before, int count) {

            //}

            //@Override
            //public void afterTextChanged(Editable s) {

            //}
        //});
        btn_m.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                //Aconseguir el text que hem escrit. El "to string" es para obtener solo el texto.//
                String skm= text_km.getText().toString();
                float km= Float.parseFloat(skm);
                float millas= km/1.609f;
                //Pnemos una f al final para dividir floats, sino divide float entre double//
                //Ahora hacemos la inversa para obtener que las millas sean un numero.//
                //El get text es para cojerlo, es set text para enseñarlo//
                String smillas= String.format("%f", millas);
                text_m.setText(smillas);

                //Comprobar que se ha cliacado. La clase Log solo lo ve el programador. (Android monitor)//
                Log.i("Leila", "btn_m se ha clicado!");

            }
        });

        btn_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smillas= text_m.getText().toString();
                float millas= Float.parseFloat(smillas);
                float km= millas*1.609f;
                String skm= String.format("%f", km);
                text_km.setText(skm);

            }
        });


    }
}
