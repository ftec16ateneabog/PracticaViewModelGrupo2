package com.atenea.practicaviewmodel.Models;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static Usuario _usuario = new Usuario("nombre1","Apellido1","12345");
    public static Usuario registrar(Usuario usuario)
    {
        _usuario = usuario;
        return usuario;
    }
}
