package com.example.consumoapisretrofit.Views;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.consumoapisretrofit.Dto.EstudianteDto;
import com.example.consumoapisretrofit.Interface.EstudianteInterfaz;
import com.example.consumoapisretrofit.Model.Estudiante; // Asegúrate de importar tu modelo de datos
import com.example.consumoapisretrofit.R;
import com.example.consumoapisretrofit.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    EditText nameText;
    EditText nameedad;
    EditText namedireccion;
    EditText nameciudad;
    EditText namepais;
    EditText nameApellido;
    Button createButton;
    Button createButton2;
    EstudianteInterfaz crudInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameText = findViewById(R.id.etNombres);
        nameApellido = findViewById(R.id.etApellidos);
        nameedad = findViewById(R.id.etEdad);
        namedireccion = findViewById(R.id.etDireccion);
        nameciudad = findViewById(R.id.etCiudad);
        namepais = findViewById(R.id.etPais);// Asegúrate de que este sea el ID correcto
        createButton = findViewById(R.id.btnSubmit);
        createButton2 = findViewById(R.id.btnSubmit2); // Asegúrate de que este sea el ID correcto

        createButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí creas un Intent para la actividad a la que deseas regresar
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // Inicializa la interfaz Retrofit


        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                createButton.setEnabled(buttonEnabled());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        createButton.setEnabled(buttonEnabled());

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int edad = Integer.parseInt(nameedad.getText().toString());



                // Crea un objeto EstudianteDto con los datos
                EstudianteDto dto = new EstudianteDto(nameText.getText().toString(),nameApellido.getText().toString(), edad,namedireccion.getText().toString(),
                        nameciudad.getText().toString(), namepais.getText().toString());



                // Llama al método para crear el estudiante
                createEstudiante(dto);
            }
        });



    }

    private void createEstudiante(EstudianteDto dto) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) // Reemplaza Constants.BASE_URL con tu URL base
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(EstudianteInterfaz.class);
        Call<Estudiante> call = crudInterface.create(dto);

        call.enqueue(new Callback<Estudiante>() {
            @Override
            public void onResponse(Call<Estudiante> call, Response<Estudiante> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity2.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                    Log.e("Response err: ", response.message());
                    return;
                }

                Estudiante estudiante = response.body();



                // Luego de crear el estudiante, puedes realizar alguna acción adicional, como regresar a otra actividad.
                // Por ejemplo:
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }


            @Override
            public void onFailure(Call<Estudiante> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean buttonEnabled() {
        return nameText.getText().toString().trim().length() > 0;
    }

    ///////////////////////////EDIT//////////////////////////////////////////////////////
   /* private void EditEstudiante(EstudianteDto dto) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) // Reemplaza Constants.BASE_URL con tu URL base
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(EstudianteInterfaz.class);
        Call<Estudiante> call = crudInterface.create(dto);

        call.enqueue(new Callback<Estudiante>() {
            @Override
            public void onResponse(Call<Estudiante> call, Response<Estudiante> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity2.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                    Log.e("Response err: ", response.message());
                    return;
                }

                Estudiante estudiante = response.body();



                // Luego de crear el estudiante, puedes realizar alguna acción adicional, como regresar a otra actividad.
                // Por ejemplo:
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }


            @Override
            public void onFailure(Call<Estudiante> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/
















}
