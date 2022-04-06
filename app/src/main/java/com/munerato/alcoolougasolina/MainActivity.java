package com.munerato.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.edtAlcool);
        editPrecoGasolina = findViewById(R.id.edtGasolina);
        txtResultado = findViewById(R.id.txtResultado);

    }

    public void calcularPreco(View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resultado = valorAlcool/valorGasolina;

            if(resultado >=0.7){
                txtResultado.setText("Melhor Opção Gasolina");
            }else {
                txtResultado.setText("Melhor Opção Alcool");
            }


        }else{
            txtResultado.setText("Preencha os Campos Primeiro");
        }


    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;
        String campo = "Preenchido";

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;

        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;

        }

        return camposValidados;

    }
}