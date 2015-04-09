package gilz.edvard.bixnia.controlgastos.metodos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

    public Double QuitarIva(double conIva) {
        double sinIva = (conIva / 1.16);
        return sinIva;
    }

    public void GuardarCantidad(Context context, String cantidad, String iva, String dia, String mes, String anio, int tipo) {

        ConexionDB conexionDB = new ConexionDB(context, "ControlGastos", null, 1);
        SQLiteDatabase database = conexionDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("CANTIDAD", cantidad);
        values.put("IVA", iva);
        values.put("DIA", dia);
        values.put("MES", mes);
        values.put("ANIO", anio);
        if (tipo == 0) {
            database.insert("CCF", null, values);
            Toast.makeText(context, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }
        else {
            database.insert("VCF", null, values);
            Toast.makeText(context, "Venta Registrada", Toast.LENGTH_SHORT).show();
        }
        database.close();
    }

    public void GuardarCantidad(Context context, String cantidad, String dia, String mes, String anio, int tipo) {

        ConexionDB conexionDB = new ConexionDB(context, "ControlGastos", null, 1);
        SQLiteDatabase database = conexionDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("CANTIDAD", cantidad);
        values.put("DIA", dia);
        values.put("MES", mes);
        values.put("ANIO", anio);
        if (tipo == 0) {
            database.insert("CSF", null, values);
            Toast.makeText(context, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }
        else {
            database.insert("VSF", null, values);
            Toast.makeText(context, "Venta Registrada", Toast.LENGTH_SHORT).show();
        }
        database.close();
    }

    public String getDay() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        String Dia = simpleDateFormat.format(new Date());

        return Dia;
    }

    public String getMonth() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        String Mes = simpleDateFormat.format(new Date());

        return Mes;
    }

    public String getYear() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String Anio = simpleDateFormat.format(new Date());

        return Anio;
    }
}
