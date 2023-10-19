package com.app.evaluacion2.models.services;

public class MiServicioComplejo implements IServicio{
    @Override
    public String operacion(){
        return "Ejecutando algun proceso importante complicado...";
    }
}