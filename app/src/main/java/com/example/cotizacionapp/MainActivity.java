package com.example.cotizacionapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private EditText txtNumCotizacion;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPorcentaje;
    private EditText txtPlazo;
    private Button btnCalcular;
    private Button btnVaciar;
    private Button btnCerrar;
    private TextView mostrarResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumCotizacion = (EditText) findViewById(R.id.txtNumCotizacion);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtPorcentaje = (EditText) findViewById(R.id.txtPorcentaje);
        txtPlazo = (EditText) findViewById(R.id.txtPlazo);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnVaciar = (Button) findViewById(R.id.btnVaciar);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);
        mostrarResultados = (TextView) findViewById(R.id.mostrarResultados);

        Cotizacion cotizacion = new Cotizacion();
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroCotizacion = txtNumCotizacion.getText().toString();
                cotizacion.setNumCotizacion(Integer.parseInt(numeroCotizacion));
                cotizacion.setDescripcion(txtDescripcion.getText().toString());
                String precio = txtPrecio.getText().toString();
                cotizacion.setPrecio(Double.parseDouble(precio));
                String porcentajePago = txtPorcentaje.getText().toString();
                cotizacion.setPorcentajeInicial(Double.parseDouble(porcentajePago));
                String plazo = txtPlazo.getText().toString();
                cotizacion.setPlazo(Integer.parseInt(plazo));
                
                Double pagoInicial = cotizacion.calcularPagoInicial();
                Double pagoFinal = cotizacion.calcularTotalFinanciar();
                Double pagoMensual = cotizacion.calcularPagoMensual();

                mostrarResultados.setText("\n---COTIZACIÓN---" +
                        "\n\nNúmero de cotización: " + cotizacion.getNumCotizacion() +
                        "\nDescripción: " + cotizacion.getDescripcion() +
                        "\nPrecio: " + cotizacion.getPrecio() +
                        "\nPorcentaje de pago inicial: " + cotizacion.getPorcentajeInicial() +
                        "\nPlazo: " + cotizacion.getPlazo() +
                        "\nPago inicial: " + pagoInicial +
                        "\nTotal a financiar: " + pagoFinal +
                        "\nPago mensual: " + pagoMensual);
            }
        });

        btnVaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNumCotizacion.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtPorcentaje.setText("");
                txtPlazo.setText("");
                mostrarResultados.setText("");
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}