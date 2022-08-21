package com.company;

import com.company.daos.OdontologoDaoH2;
import com.company.model.Odontologo;
import com.company.servicios.ServicesOdontologo;

public class Main {

    public static void main(String[] args) {
        Odontologo odontologo = new Odontologo();
        odontologo.setNumeroMatricula(5);
        odontologo.setNombre("miguel");
        odontologo.setApellido("arias");


        ServicesOdontologo servicesOdontologo = new ServicesOdontologo();
        servicesOdontologo.setOdontologoIDao(new OdontologoDaoH2());
        // write your code here
        servicesOdontologo.guardarOdontologo(odontologo);
    }
}
