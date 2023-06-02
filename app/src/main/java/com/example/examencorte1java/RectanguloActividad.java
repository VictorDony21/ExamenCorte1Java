package com.example.examencorte1java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class RectanguloActividad extends AppCompatActivity {

    private EditText txtBase, txtAltura, txtArea, txtPerimetro;
    private TextView lblNombre;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo_actividad);

        lblNombre = findViewById(R.id.lblNombre);

        txtBase = findViewById(R.id.txtBase);
        txtAltura = findViewById(R.id.txtAltura);
        txtArea = findViewById(R.id.txtArea);
        txtPerimetro = findViewById(R.id.txtPerimetro);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);


        String nombre = getIntent().getStringExtra("nombre");
        lblNombre.setText("Mi nombre es... " + nombre);






    }



}
