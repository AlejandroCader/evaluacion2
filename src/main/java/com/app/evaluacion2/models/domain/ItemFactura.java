package com.app.evaluacion2.models.domain;

public class ItemFactura {
    private Producto producto;
    private Integer cantidad;
    private Categoria categoria;

    public ItemFactura(Producto producto, Integer cantidad, Categoria categoria) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer calcularImporte(){
        return cantidad * producto.getPrecio();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
