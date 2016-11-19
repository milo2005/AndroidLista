package unicauca.movil.restaurantes;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.restaurantes.adapters.RestauranteAdapter;
import unicauca.movil.restaurantes.models.Restaurante;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    List<Restaurante> data;
    RestauranteAdapter adapter;
    ListView list;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        data = new ArrayList<Restaurante>();
        adapter = new RestauranteAdapter(this, data);

        list.setAdapter(adapter);
        registerForContextMenu(list);
        loadRestaurantes();
    }

    public void loadRestaurantes(){
        data.clear();

        Restaurante r1 = new Restaurante();
        r1.setNombre("Mesa Larga");
        r1.setDireccion("Bolivar");
        r1.setCalificacion(4);

        Restaurante r2 = new Restaurante();
        r2.setNombre("Carantanta");
        r2.setDireccion("Parque Carantanta");
        r2.setCalificacion(4.5f);

        Restaurante r3 = new Restaurante();
        r3.setNombre("El Quijote");
        r3.setDireccion("Parque Carantanta");
        r3.setCalificacion(4.3f);

        data.add(r1);
        data.add(r2);
        data.add(r3);

        adapter.notifyDataSetChanged();
    }

    //region OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Toast.makeText(this, "Menu Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_filter_name:
                Toast.makeText(this, "Menu Filter Name", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_filter_score:
                Toast.makeText(this, "Menu Filter Score", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        pos = info.position;

        switch (item.getItemId()){
            case R.id.action_delete:
                deleteAlert();
                break;
            case R.id.action_edit:
                Toast.makeText(this, "Menu Edit", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
    //endregion

    public void addItem(){

    }

    public void deleteAlert(){
        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle(R.string.alert_title)
                .setMessage(R.string.alert_msg)
                .setPositiveButton(R.string.ok,this)
                .setNegativeButton(R.string.cancel, this)
                .create();
        alert.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if( i == DialogInterface.BUTTON_POSITIVE){
            data.remove(pos);
            adapter.notifyDataSetChanged();
        }
    }
}
