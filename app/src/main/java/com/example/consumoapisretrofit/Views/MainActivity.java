package com.example.consumoapisretrofit.Views;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.example.consumoapisretrofit.Adapter.EstudianteAdapter;
import com.example.consumoapisretrofit.Interface.EstudianteInterfaz;
import com.example.consumoapisretrofit.Model.Estudiante;
import com.example.consumoapisretrofit.R;
import com.example.consumoapisretrofit.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Estudiante> products;
    EstudianteInterfaz crudInterface;
    EstudianteAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BTOM
        Button btnAgregar = findViewById(R.id.btnAgregar);
        adapter = new EstudianteAdapter(new ArrayList<>(), this);
        listView = findViewById(R.id.listView);

        // Reemplaza con el ID de tu ListView en el diseño
        listView.setAdapter(adapter);
        getAll();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para abrir la segunda actividad
               Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                // Iniciar la segunda actividad
                startActivity(intent);
            }
        });



    }
    private void getAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(EstudianteInterfaz.class);
        Call<List<Estudiante>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Estudiante>>() {

            @Override
            public void onResponse(Call<List<Estudiante>> call, Response<List<Estudiante>> response) {
                if(!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err: ", response.message());
                    return;
                }
                products = response.body();
                EstudianteAdapter productsAdapter = new EstudianteAdapter(products, getApplicationContext());
                listView.setAdapter(productsAdapter);
                products.forEach(p -> Log.i("Prods: ", p.toString()));
            }


            @Override
            public void onFailure(Call<List<Estudiante>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ", t.getMessage());
            }
        });
    }


}