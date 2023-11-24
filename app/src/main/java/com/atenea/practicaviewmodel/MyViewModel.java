package com.atenea.practicaviewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.atenea.practicaviewmodel.Models.Model;
import com.atenea.practicaviewmodel.Models.Usuario;

import java.io.Serializable;

public class MyViewModel extends ViewModel implements Serializable {
    private MutableLiveData<Usuario> result;

    public MyViewModel()
    {
        result = new MutableLiveData<>();
    }
    public LiveData<Usuario> getResultado(){
        return result;
    }
    public void registrar(Usuario usuario)
    {
        result.setValue(Model.registrar(usuario));
    }
}