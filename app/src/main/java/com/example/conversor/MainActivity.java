package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mavm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        mavm = ViewModelProvider.AndroidViewModelFactory
                .getInstance(getApplication())
                .create(MainActivityViewModel.class);
        mavm.getValor().observe(this, d -> {bind.etCambio.setText(d.toString());});
        bind.bConvertir.setOnClickListener(view ->{
            mavm.convertir(
                    bind.rbDolaresaEuros.isChecked(),
                    bind.etDolares.getText().toString(),
                    bind.etEuros.getText().toString()
            );
        });
    }
}

/*

habilita y deshabilita los EditText segun el radio button activo
no muy util en este caso

bind.rgGrupo.setOnCheckedChangeListener(
    (radioGroup, i) -> {
        //
        bind.etEuros.setFocusable(bind.rbEurosaDolares.isChecked());
        bind.etEuros.setFocusableInTouchMode(bind.rbEurosaDolares.isChecked());
        bind.etEuros.setClickable(bind.rbEurosaDolares.isChecked());
        bind.etEuros.setLongClickable(bind.rbEurosaDolares.isChecked());

        bind.etDolares.setFocusable(bind.rbDolaresaEuros.isChecked());
        bind.etDolares.setFocusableInTouchMode(bind.rbDolaresaEuros.isChecked());
        bind.etDolares.setClickable(bind.rbDolaresaEuros.isChecked());
        bind.etDolares.setLongClickable(bind.rbDolaresaEuros.isChecked());
    }
);

*/