package com.example.jeanc.crud_pessoa;

import android.widget.ArrayAdapter;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import java.util.List;

public class AdaptadorP extends ArrayAdapter<Pessoas> {

    private Context context;
    private List<Pessoas> pessoas;

    public AdaptadorP(@NonNull Context context, @LayoutRes int resource, @NonNull List<Pessoas> objects) {
        super(context, resource, objects);
        this.context = context;
        this.pessoas = objects;
    }
    public View getView(final int pos, View convertView, ViewGroup viewGroup){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_listar, viewGroup, false);

        TextView id = (TextView) rowView.findViewById(R.id.etID);
        TextView nome = (TextView) rowView.findViewById(R.id.etNome);
        TextView sobrenome = (TextView) rowView.findViewById(R.id.etSobrenome);

        id.setText(String.format("Id: %d", pessoas.get(pos).getID()));
        nome.setText(String.format("Nome: %s", pessoas.get(pos).getFirstName()));
        sobrenome.setText(String.format("Sobrenome: %s", pessoas.get(pos).getLastName()));

        return rowView;
    }
}
