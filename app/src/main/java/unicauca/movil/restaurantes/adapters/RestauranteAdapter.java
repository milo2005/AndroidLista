package unicauca.movil.restaurantes.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unicauca.movil.restaurantes.R;
import unicauca.movil.restaurantes.models.Restaurante;

/**
 * Created by Dario Chamorro on 16/11/2016.
 */

public class RestauranteAdapter extends BaseAdapter {

    Context context;
    List<Restaurante> data;

    public RestauranteAdapter(Context context, List<Restaurante> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        if(view == null)
            v = View.inflate(context, R.layout.template_restaurante, null);
        else
            v = view;

        Restaurante o = (Restaurante) getItem(i);

        TextView title = (TextView) v.findViewById(R.id.title);
        TextView subtitle = (TextView) v.findViewById(R.id.subtitle);
        TextView score = (TextView) v.findViewById(R.id.score);

        title.setText(o.getNombre());
        subtitle.setText(o.getDireccion());
        score.setText(""+o.getCalificacion());

        return v;
    }
}
