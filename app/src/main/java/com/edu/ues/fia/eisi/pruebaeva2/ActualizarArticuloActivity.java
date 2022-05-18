package com.edu.ues.fia.eisi.pruebaeva2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActualizarArticuloActivity extends AppCompatActivity {
    ControlBD helper;
    EditText idarticulo, nomarticulo, tipoarticulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_articulo);
        helper = new ControlBD(this);
        idarticulo = (EditText) findViewById(R.id.idarticuloActualizar);
        nomarticulo = (EditText) findViewById(R.id.nomarticulo);
        tipoarticulo = (EditText) findViewById(R.id.tipoArticulo);


    }

    public void actualizarArticulo(View v){
        ARTICULO articulo = new ARTICULO();
        articulo.setIdArticulo(idarticulo.getText().toString());
        articulo.setNomArticulo(nomarticulo.getText().toString());
        articulo.setTipoArticulo(tipoarticulo.getText().toString());

        helper.abrir();
        String estado = helper.actualizarArticulo(articulo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
}