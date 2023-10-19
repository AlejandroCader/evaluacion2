package com.app.evaluacion2.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
public class Factura {

    private static final long serialVersionUID = 946004357128146951L;

    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;


    @Autowired
    private List<ItemFactura> items;

    @PostConstruct
    public void incializar(){
        cliente.setNombre(cliente.getNombre().concat(" " ).concat(cliente.getApellido()));
        descripcion = descripcion.concat(" del cliente: ")
                .concat(cliente.getNombre());
    }

    @PreDestroy
    public void destruir(){
        System.out.println("Factura destruida: ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

    public Integer calcularTotalFactura() {
        Integer total = 0;
        for (ItemFactura item : items) {
            total += item.calcularImporte();
        }
        return total;
    }

}
