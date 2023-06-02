package com.example.examencorte1java;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnEntrar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString().trim();
                if (txtNombre.getText().toString().isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, RectanguloActividad.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Ingrese un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Cerrar aplicación");
                builder.setMessage("¿Estás seguro de que quieres cerrar la aplicación?");

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
        });
    }
}
