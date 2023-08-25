package com.example.conversor;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    Context context;
    MutableLiveData<Double> valor = new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Double> getValor(){
        return valor;
    }

    public void convertir(boolean rb, String dolares, String euros){

        double d = dolares.isEmpty() || dolares.equals(".") ? 0 : Double.parseDouble(dolares);
        double e = euros.isEmpty() || euros.equals(".") ? 0 : Double.parseDouble(euros);
        if (rb) {
            valor.setValue(d*0.92660);
        } else {
            valor.setValue(e*1.08);
        }

    }


}
