package br.ulbra.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText pot, hora, preco;
    private TextView resultadoConsumo, resultadoCusto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pot = findViewById(R.id.edtPot);
        hora = findViewById(R.id.edtHora);
        preco = findViewById(R.id.edtpreco);
        resultadoConsumo = findViewById(R.id.txtR1);
        resultadoCusto = findViewById(R.id.txtR2);
        ImageButton calcularButton = findViewById(R.id.btnCalcular);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        try {
            double potencia = Double.parseDouble(pot.getText().toString());
            double horas = Double.parseDouble(hora.getText().toString());
            double precoKwh = Double.parseDouble(preco.getText().toString());

            // Cálculos
            double consumoEnergia = (potencia * horas) / 1000; // kWh
            double custo = consumoEnergia * precoKwh; // R$

            // Exibir Resultados
            resultadoConsumo.setText(String.format("Consumo: %.2f kWh", consumoEnergia));
            resultadoCusto.setText(String.format("Custo: R$ %.2f", custo));

            // Tornar os TextViews visíveis
            resultadoConsumo.setVisibility(View.VISIBLE);
            resultadoCusto.setVisibility(View.VISIBLE);
        } catch (NumberFormatException e) {
            resultadoConsumo.setText("Erro: Insira valores válidos.");
            resultadoCusto.setText("");
        }
    }
}
