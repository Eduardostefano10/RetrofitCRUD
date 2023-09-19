package com.example.consumoapisretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.consumoapisretrofit.Views.MainActivity;
import com.example.consumoapisretrofit.Model.Estudiante;
import com.example.consumoapisretrofit.R;

import java.util.List;

public class EstudianteAdapter extends BaseAdapter {
    private List<Estudiante> estudiantes;
    private Context context;

    public EstudianteAdapter(List<Estudiante> estudiantes, Context context) {
        this.estudiantes = estudiantes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return estudiantes.size();
    }

    @Override
    public Object getItem(int position) {
        return estudiantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return estudiantes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.estudiante_item, parent, false);
        }

        TextView nombreTextView = convertView.findViewById(R.id.nombreTextView);
        TextView edadTextView = convertView.findViewById(R.id.edadTextView);
        TextView direccionTextView = convertView.findViewById(R.id.direccionTextView);
        TextView ciudadTextView = convertView.findViewById(R.id.ciudadTextView);
        TextView paisTextView = convertView.findViewById(R.id.paisTextView);


        nombreTextView.setText(estudiantes.get(position).getNombres());
        edadTextView.setText(String.valueOf(estudiantes.get(position).getEdad()));
        direccionTextView.setText(estudiantes.get(position).getDireccion());
        ciudadTextView.setText(estudiantes.get(position).getCiudad());
        paisTextView.setText(estudiantes.get(position).getPais());



        return convertView;
    }

    private void callDetail(long id) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("id", id);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
