package com.example.examencorte1java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RectanguloActividad extends AppCompatActivity {

    private EditText txtBase, txtAltura;
    private TextView lblNombre , txtArea, txtPerimetro;
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


// Botón para calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    calcularRectangulo();

                } else {
                    Toast.makeText(RectanguloActividad.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Botón de limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });

        // Botón para salir al login
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarSalida();
            }
        });



    }


    private boolean validarCampos() {
        boolean camposCompletos = true;
        if (txtBase.getText().toString().isEmpty()) {
            txtBase.setError("Campo obligatorio");
            camposCompletos = false;
        }
        if (txtAltura.getText().toString().isEmpty()) {
            txtAltura.setError("Campo obligatorio");
            camposCompletos = false;
        }
        return camposCompletos;
    }

    private void calcularRectangulo(){
        // Obtener los datos enviados desde la actividad anterior
        double base = Double.parseDouble(txtBase.getText().toString());
        double altura = Double.parseDouble(txtAltura.getText().toString());

        // Crear una instancia de la clase Rectangulo y realizar los cálculos
        Rectangulo rectangulo = new Rectangulo(base, altura);
        double area = rectangulo.calcularArea();
        double perimetro = rectangulo.calcularPerimetro();

        // Mostrar los resultados en los TextViews correspondientes
        txtArea.setText("" + area);

        txtPerimetro.setText("" + perimetro);
    }


    private void limpiarCampos() {
        txtBase.setText("");
        txtAltura.setText("");
        txtArea.setText("");
        txtPerimetro.setText("");
    }

    private void confirmarSalida() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RectanguloActividad.this);
        builder.setTitle("Regresar");
        builder.setMessage("¿Estás seguro de que quieres regresar?");

        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Cerrar la actividad actual y salir de la aplicación
            }
        });

        builder.setNegativeButton("No", null); // No hacer nada si se selecciona "No"

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
