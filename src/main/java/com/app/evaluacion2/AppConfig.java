package com.app.evaluacion2;

import com.app.evaluacion2.models.domain.Categoria;
import com.app.evaluacion2.models.domain.ItemFactura;
import com.app.evaluacion2.models.domain.Producto;
import com.app.evaluacion2.models.services.IServicio;
import com.app.evaluacion2.models.services.MiServicio;
import com.app.evaluacion2.models.services.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    @Primary
    public IServicio registrarMiServicio(){
        return new MiServicio();
    }
    @Bean("miServicioComplejo")
    public IServicio registrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFacturaFarmacia")
    @Primary
    public List<ItemFactura> registrarItemsFarmacia(){

        Categoria CuidadoBucal = new Categoria("Cuidado Bucal");
        Categoria CuidadoCorporal = new Categoria("Cuidado Corporal");

        Producto producto1 = new Producto("Enjuague bucal Plex",5);
        Producto producto2 = new Producto("Cepillo de dientes Oral B",2);
        Producto producto3 = new Producto("Crema corporal nivea",13);
        Producto producto4 = new Producto("Bloqueador solar Banana Boat",7);


        CuidadoBucal.agregarProducto(producto1);
        CuidadoBucal.agregarProducto(producto2);
        CuidadoCorporal.agregarProducto(producto3);
        CuidadoCorporal.agregarProducto(producto4);

        ItemFactura linea1 = new ItemFactura(producto1,2, CuidadoBucal);
        ItemFactura linea2 = new ItemFactura(producto2,1, CuidadoBucal);
        ItemFactura linea3 = new ItemFactura(producto3,1, CuidadoCorporal);
        ItemFactura linea4 = new ItemFactura(producto4,1, CuidadoCorporal);

        return Arrays.asList(linea1,linea2,linea3,linea4);
    }

}