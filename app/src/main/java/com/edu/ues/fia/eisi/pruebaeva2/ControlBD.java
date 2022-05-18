package com.edu.ues.fia.eisi.pruebaeva2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBD {

    private static final String[] camposCliente = new String[]
            {"idcliente", "nombre", "apellido", "sexo", "numarticulo"};
    private static final String[] camposArticulo = new String[]
            {"idarticulo", "nomarticulo", "tipoarticulo"};
    private static final String[] camposFactura = new String[]
            {"idcliente", "idarticulo", "numfactura", "montoventa"};
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "PRUEBAEVALUADO.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE cliente(idcliente VARCHAR(7) NOT NULL PRIMARY KEY,nombre VARCHAR(30),apellido VARCHAR(30),sexo VARCHAR(1),numarticulo INTEGER);");
                db.execSQL("CREATE TABLE articulo(idarticulo VARCHAR(6) NOT NULL PRIMARY KEY,nomarticulo VARCHAR(30),tipoarticulo VARCHAR(1));");
                db.execSQL("CREATE TABLE factura(idcliente VARCHAR(6) NOT NULL ,idarticulo VARCHAR(6) NOT NULL ,numfactura VARCHAR(5) ,montoventa REAL ,PRIMARY KEY(idcliente,idarticulo,numfactura));");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }

    public String insertarCliente(CLIENTE cliente) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues alum = new ContentValues();
        alum.put("idcliente", cliente.getIdCLiente());
        alum.put("nombre", cliente.getNombre());
        alum.put("apellido", cliente.getApellido());
        alum.put("sexo", cliente.getSexo());
        alum.put("numarticulo", cliente.getNumArticulo());
        contador=db.insert("cliente", null, alum);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertarArticulo(ARTICULO articulo) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues alum = new ContentValues();
        alum.put("idarticulo", articulo.getIdArticulo());
        alum.put("nomarticulo", articulo.getNomArticulo());
        alum.put("tipoarticulo", articulo.getTipoArticulo());
        contador=db.insert("articulo", null, alum);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertarFactura(FACTURA factura) {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues alum = new ContentValues();
        alum.put("idcliente", factura.getIdcliente());
        alum.put("idarticulo", factura.getIdArticulo());
        alum.put("numfactura", factura.getNumfactura());
        alum.put("montoventa", factura.getMontoventa());

        contador=db.insert("factura", null, alum);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }


    public String actualizarArticulo(ARTICULO articulo) {
        if(verificarIntegridad(articulo, 2)){
            String[] id = {articulo.getIdArticulo()};
            ContentValues cv = new ContentValues();
            cv.put("nomarticulo", articulo.getNomArticulo());
            cv.put("tipoarticulo", articulo.getTipoArticulo());
            db.update("articulo", cv, "idarticulo = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }
    }


    public String eliminarCliente(CLIENTE cliente) {
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(cliente,3)) {
           // contador+=db.delete("cliente", "idCliente='"+alumno.getCarnet()+"'", null);
            return "Registro relacionado a Factura no se pueude eliminar";
        }
        else{
            contador+=db.delete("cliente", "idcliente='"+cliente.getIdCLiente()+"'", null);
            regAfectados+=contador;
            return regAfectados;
        }

    }

   private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
           /* case 1:
            {
//verificar que al insertar nota exista carnet del alumno y el
                codigo de materia
                Nota nota = (Nota)dato;
                String[] id1 = {nota.getCarnet()};
                String[] id2 = {nota.getCodmateria()};
//abrir();
                Cursor cursor1 = db.query("alumno", null, "carnet = ?", id1, null,
                        null, null);
                Cursor cursor2 = db.query("materia", null, "codmateria = ?", id2,
                        null, null, null);
                if(cursor1.moveToFirst() && cursor2.moveToFirst()){
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2:
            {
//verificar que al modificar nota exista carnet del alumno, el
                codigo de materia y el ciclo
                Nota nota1 = (Nota)dato;
                String[] ids = {nota1.getCarnet(), nota1.getCodmateria(),
                        nota1.getCiclo()};
                abrir();
                Cursor c = db.query("nota", null, "carnet = ? AND codmateria = ? AND
                        ciclo = ?", ids, null, null, null);
                if(c.moveToFirst()){
//Se encontraron datos
                    return true;
                }
                return false;
            }*/
            case 2: {
//verificar que al modificar nota exista carnet del alumno, ecodigo de materia y el ciclo
                ARTICULO articulo = (ARTICULO) dato;
                String[] ids = {articulo.getIdArticulo()};
                abrir();
                Cursor c = db.query("articulo", null, "idarticulo = ?", ids, null, null, null);
                if (c.moveToFirst()) {
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3:
            {
                CLIENTE cliente  = (CLIENTE) dato;
                Cursor c=db.query(true, "factura", new String[] {"idcliente" }, "idcliente='"+cliente.getIdCLiente()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
           /* case 4:
            {
                Materia materia = (Materia)dato;
                Cursor cmat=db.query(true, "nota", new String[] {
                                "codmateria" },
                        "codmateria='"+materia.getCodmateria()+"'",null, null, null, null, null);
                if(cmat.moveToFirst())

            }
            return true;
else
            return false;

        case 5:
        {
//verificar que exista alumno
            Alumno alumno2 = (Alumno)dato;
            String[] id = {alumno2.getCarnet()};
            abrir();
            Cursor c2 = db.query("alumno", null, "carnet = ?", id, null, null,
                    null);
            if(c2.moveToFirst()){
//Se encontro Alumno
                return true;
            }
            return false;
        }
        case 6:
        {
//verificar que exista Materia
            Materia materia2 = (Materia)dato;
            String[] idm = {materia2.getCodmateria()};
            abrir();
            Cursor cm = db.query("materia", null, "codmateria = ?", idm, null,
                    null, null);
            if(cm.moveToFirst()){
//Se encontro Materia
                return true;
            }
            return false;
        }*/
        default:
        return false;
    }

    }

    public String llenarBD() {
        final String[] VAidCliente = {"OO12035", "OF12044", "GG11098", "CC12021","ELIMINAR"};
        final String[] VAnombre = {"Carlos", "Pedro", "Sara", "Gabriela","ELIMINAR"};
        final String[] VAapellido = {"Orantes", "Ortiz", "Gonzales", "Coto","ELIMINAR"};
        final String[] VAsexo = {"M", "M", "F", "F","F"};
        final Integer[] Vnumarticulo = {1, 3, 5, 7, 7};
        final String[] VmidArticulo = {"MAC", "MAC1", "MAC2","MAC3"};
        final String[] nomArticulo = {"COMPUTADORA", "LAPICER", "JUEGOS", "PRUEBAS"};
        final String[] TipoArticuilo = {"OO12035", "OF12044", "GG11098", "CC12021"};
       // final String[] idCliente = {"MAT115", "PRN115", "IEC115", "TSI115", "IC115", "MAT115", "PRN115"};
        final String[] numFactura = {"MAT115", "PRN115", "IEC115", "TSI115"};
        final float[] montoventa = {7, 5, 8, 7};
        abrir();
        db.execSQL("DELETE FROM articulo");
        db.execSQL("DELETE FROM cliente");
        db.execSQL("DELETE FROM factura");
        CLIENTE cliente = new CLIENTE();
        for (int i = 0; i < 5; i++) {
            cliente.setIdCLiente(VAidCliente[i]);
            cliente.setNombre(VAnombre[i]);
            cliente.setApellido(VAapellido[i]);
            cliente.setSexo(VAsexo[i]);
            cliente.setNumArticulo(Vnumarticulo[i]);
            insertarCliente(cliente);
        }
        ARTICULO articulo = new ARTICULO();
        for (int i = 0; i < 4; i++) {
            articulo.setIdArticulo(VmidArticulo[i]);
            articulo.setNomArticulo(nomArticulo[i]);
            articulo.setTipoArticulo(TipoArticuilo[i]);
            insertarArticulo(articulo);
        }
        FACTURA factura = new FACTURA();
        for (int i = 0; i < 4; i++) {
            factura.setIdcliente(VAidCliente[i]);
            factura.setIdArticulo(VmidArticulo[i]);
            factura.setMontoventa(montoventa[i]);
            factura.setNumfactura(numFactura[i]);
            insertarFactura(factura);
        }
        cerrar();
        return "Guardo Correctamente";

    }
}



