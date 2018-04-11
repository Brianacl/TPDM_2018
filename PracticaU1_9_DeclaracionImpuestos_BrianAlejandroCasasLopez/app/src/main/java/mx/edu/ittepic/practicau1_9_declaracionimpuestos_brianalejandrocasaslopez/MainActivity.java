package mx.edu.ittepic.practicau1_9_declaracionimpuestos_brianalejandrocasaslopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editSalario, editHoras;
    TextView viewSubtotal, viewIVA, viewTotal;
    Button btnPagar;
    Spinner tipoPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSalario = findViewById(R.id.salario);
        editHoras = findViewById(R.id.horasTotales);

        viewSubtotal = findViewById(R.id.subtotal);
        viewIVA = findViewById(R.id.iva);
        viewTotal = findViewById(R.id.total);

        btnPagar = findViewById(R.id.btnPagar);
        tipoPersona = findViewById(R.id.tipoPersona);
    }

    public void obtenerDatos(View v){
        DecimalFormat df = new DecimalFormat("#.00");
        float salario= Float.parseFloat(editSalario.getText().toString());
        int horas= Integer.parseInt(editHoras.getText().toString());
        double total = 0, iva=0;

        salario = salario * horas;
        viewSubtotal.setText("Subtotal: $"+df.format(salario));

        if(tipoPersona.getSelectedItemId() == 0){
            iva = salario * 0.15;
            viewIVA.setText("IVA | 15%: $"+df.format(iva));
            total = salario * 1.15;
            viewTotal.setText("Total:      $"+df.format(total));
        }

        if(tipoPersona.getSelectedItemId() == 1){
            iva = salario * 0.18;
            viewIVA.setText("IVA | 18%: $"+df.format(iva));
            total = salario * 1.18;
            viewTotal.setText("Total:      $"+df.format(total));
        }
    }//Fin obtenerDatos
}
