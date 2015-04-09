package gilz.edvard.bixnia.controlgastos.metodos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionDB extends SQLiteOpenHelper {

    public ConexionDB(Context context, String nombre, CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CCF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, IVA REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
        db.execSQL("CREATE TABLE VCF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, IVA REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
        db.execSQL("CREATE TABLE CSF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
        db.execSQL("CREATE TABLE VSF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("DROP TABLE IF EXISTS CCF");
        db.execSQL("CREATE TABLE CCF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, IVA REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
        db.execSQL("DROP TABLE IF EXISTS VCF");
        db.execSQL("CREATE TABLE VCF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, IVA REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
        db.execSQL("DROP TABLE IF EXISTS CSF");
        db.execSQL("CREATE TABLE CSF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
        db.execSQL("DROP TABLE IF EXISTS VSF");
        db.execSQL("CREATE TABLE VSF(ID INTEGER PRIMARY KEY AUTOINCREMENT, CANTIDAD REAL, DIA INTEGER, MES INTEGER, ANIO INTEGER)");
    }
}