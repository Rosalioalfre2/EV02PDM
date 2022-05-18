package com.edu.ues.fia.eisi.pruebaeva2;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] menu={"Eliminar Cliente","Actualizar Artiiculo","LlenarBD"};
    String[]
            activities={"ClienteEliminarActivity","ActualizarArticuloActivity"};
    ControlBD helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        helper = new ControlBD(this);


        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(0, 0, 255));
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id) {
        super.onListItemClick(l, v, position, id);
        if(position!=2) {
            String nombreValue = activities[position];

            try {
                Class<?> clase = Class.forName("com.edu.ues.fia.eisi.pruebaeva2." + nombreValue);
                Intent inte = new Intent(this, clase);
                this.startActivity(inte);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            helper.abrir();
            String tost=helper.llenarBD();
            helper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }

}