package unicauca.movil.restaurantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.restaurantes.adapters.RestauranteAdapter;
import unicauca.movil.restaurantes.models.Restaurante;

public class MainActivity extends AppCompatActivity {

    List<Restaurante> data;
    RestauranteAdapter adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        data = new ArrayList<Restaurante>();
        adapter = new RestauranteAdapter(this, data);

        list.setAdapter(adapter);
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
}
