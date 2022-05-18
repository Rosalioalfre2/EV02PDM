package com.edu.ues.fia.eisi.pruebaeva2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClienteEliminarActivity extends AppCompatActivity {
ControlBD helper;
EditText idcliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_eliminar);
        helper = new ControlBD(this);

        idcliente = findViewById(R.id.idClienteEliminar);


    }

    public void eliminarCliente(View v){
        String regEliminadas;
        CLIENTE cliente=new CLIENTE();
        cliente.setIdCLiente(idcliente.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminarCliente(cliente);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}