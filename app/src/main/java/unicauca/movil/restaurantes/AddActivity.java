package unicauca.movil.restaurantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import unicauca.movil.restaurantes.models.Restaurante;
import unicauca.movil.restaurantes.util.L;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, address;
    SeekBar score;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        score = (SeekBar) findViewById(R.id.score);
        btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Restaurante res = new Restaurante();
        res.setNombre(name.getText().toString());
        res.setDireccion(address.getText().toString());
        res.setCalificacion(score.getProgress());

        L.data.add(res);
        finish();

    }
}
