package adairmarquezcarmona.reservaedit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InterActivity extends Activity {

    String nombre = "", fecha = "", hora = "";
    int personas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter);
        Bundle recibe = new Bundle();
        recibe = this.getIntent().getExtras();

        nombre = recibe.getString("nombre");
        personas = recibe.getInt("personas");
        fecha = recibe.getString("fecha");
        hora = recibe.getString("hora");

        TextView displayInfo = (TextView) findViewById(R.id.reservaInfo);
        displayInfo.setText("Reservacion a nombre de:\n" + nombre + "\n" + personas
                + " personas\nFecha: " + fecha + "\nHora: " + hora + "\n");
    }

    public void finReserva(View v){
        EditText tarjeta = (EditText) findViewById(R.id.cardNumber);
        EditText cvv = (EditText) findViewById(R.id.cardCVV);
        Intent finDatos = new Intent(this, Actividad2.class);
        Bundle datos = new Bundle();
        datos.putString("nombre", nombre);
        datos.putInt("personas", personas);
        datos.putString("fecha", fecha);
        datos.putString("hora", hora);
        datos.putString("tarjeta", tarjeta.getText().toString().trim());
        datos.putString("cvv", cvv.getText().toString().trim());
        finDatos.putExtras(datos);
        finish();
        startActivity(finDatos);
    }

}
