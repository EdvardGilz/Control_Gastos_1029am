package gilz.edvard.bixnia.controlgastos;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

import gilz.edvard.bixnia.controlgastos.metodos.Utilidades;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;

    Utilidades util = new Utilidades();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCSF = (Button) findViewById(R.id.btnGuardar1);
        btnCSF.setOnClickListener(this);

        Button btnCCF = (Button) findViewById(R.id.btnGuardar2);
        btnCCF.setOnClickListener(this);

        Button btnVSF = (Button) findViewById(R.id.btnGuardar3);
        btnVSF.setOnClickListener(this);

        Button btnVCF = (Button) findViewById(R.id.btnGuardar4);
        btnVCF.setOnClickListener(this);

        editText1 = (EditText) findViewById(R.id.etxCantCSF);
        editText2 = (EditText) findViewById(R.id.etxCantCCF);
        editText3 = (EditText) findViewById(R.id.etxCantVSF);
        editText4 = (EditText) findViewById(R.id.etxCantVCF);

        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_compra_s_fac));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_compra_c_fac));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_venta_s_fac));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_venta_c_fac));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_resumen));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnGuardar1) {
            double cantidad = Double.parseDouble(editText1.getText().toString());

            String can = Double.toString(cantidad);
            String Dia = util.getDay();
            String Mes = util.getMonth();
            String Anio = util.getYear();

            util.GuardarCantidad(this, can, Dia, Mes, Anio, 0);
        }
        else if (v.getId() == R.id.btnGuardar2) {
            double cantidadConIva = Double.parseDouble(editText2.getText().toString());
            double IvaDesglosado = util.QuitarIva(cantidadConIva);

            String cci = Double.toString(cantidadConIva);
            String csi = Double.toString(IvaDesglosado);
            String Dia = util.getDay();
            String Mes = util.getMonth();
            String Anio = util.getYear();

            util.GuardarCantidad(this, cci, csi, Dia, Mes, Anio, 0);
        }
        else if (v.getId() == R.id.btnGuardar3) {
            double cantidad = Double.parseDouble(editText3.getText().toString());

            String can = Double.toString(cantidad);
            String Dia = util.getDay();
            String Mes = util.getMonth();
            String Anio = util.getYear();

            util.GuardarCantidad(this, can, Dia, Mes, Anio, 1);
        }
        else if (v.getId() == R.id.btnGuardar4) {
            double cantidadConIva = Double.parseDouble(editText4.getText().toString());
            double IvaDesglosado = util.QuitarIva(cantidadConIva);

            String cci = Double.toString(cantidadConIva);
            String csi = Double.toString(IvaDesglosado);
            String Dia = util.getDay();
            String Mes = util.getMonth();
            String Anio = util.getYear();

            util.GuardarCantidad(this, cci, csi, Dia, Mes, Anio, 1);
        }
    }


}
