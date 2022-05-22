package com.example.appboleto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Boleto boleto = new Boleto();
    private EditText txtNombre, txtFecha, txtPrecio, txtEdad, txtCodigo;
    private Spinner spnDestinos;
    private Spinner spnTipoBoleto;
    private TextView lblResultado;
    private Button btnCalcular, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        spnDestinos = (Spinner) findViewById(R.id.spnDestino);
        spnTipoBoleto = (Spinner) findViewById(R.id.spnTipoBoleto);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        ArrayAdapter<String> adaptadorDestinos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.destinos));
        spnDestinos.setAdapter(adaptadorDestinos);

        ArrayAdapter<String> adaptadorTipoBoleto = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tipoBoleto));
        spnTipoBoleto.setAdapter(adaptadorTipoBoleto);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCodigo.getText().toString().matches("") || txtNombre.getText().toString().matches("") || txtFecha.getText().toString().matches("") || txtPrecio.getText().toString().matches("") || txtEdad.getText().toString().matches("") || spnDestinos.getSelectedItem().toString().matches("Seleccione el destino:") || spnTipoBoleto.getSelectedItem().toString().matches("Seleccione el tipo de boleto:")){
                    Toast.makeText(MainActivity.this, "Capture todos los datos", Toast.LENGTH_SHORT).show();
                }else{
                    boleto = new Boleto(Integer.parseInt(txtCodigo.getText().toString()), txtNombre.getText().toString(), spnDestinos.getSelectedItem().toString(), spnTipoBoleto.getSelectedItem().toString(), txtFecha.getText().toString(), Float.parseFloat(txtPrecio.getText().toString()));
                    boleto.setEdad(Integer.parseInt(txtEdad.getText().toString()));
                    lblResultado.setText(boleto.imprimirBoleto());
                }

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCodigo.setText("");
                txtNombre.setText("");
                txtFecha.setText("");
                txtPrecio.setText("");
                txtEdad.setText("");
                spnDestinos.setAdapter(adaptadorDestinos);
                spnTipoBoleto.setAdapter(adaptadorTipoBoleto);
                lblResultado.setText("");
            }
        });
    }
}