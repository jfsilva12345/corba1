/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_ges_usuarios;

import java.util.ArrayList;

import org.omg.CORBA.BooleanHolder;

import sop_corba.GestionPersonalPOA;
import sop_corba.GestionPersonalPackage.personalDTO;
import sop_corba.GestionPersonalPackage.personalDTOHolder;

public class GestionUsuariosImpl extends GestionPersonalPOA{


    private ArrayList<personalDTO> personal;

    public GestionUsuariosImpl()
    {
        this.personal = new ArrayList<>();
    }

    @Override
    public void registrarPersonal(personalDTO objPersonal, BooleanHolder res) {
        System.out.println("Entrando a registrar usuario");
        res.value=false;
        if(personal.size() < 3)
        {            
            res.value=personal.add(objPersonal);
            System.out.println("Usuario registrado: \n \t identificación: " + objPersonal.getId() + ",\n \t  nombres: " + objPersonal.getNombreCompleto());
        }
        
    }

    @Override
    public boolean consultarPersonal(int id, personalDTOHolder objPersonal) {
        System.out.println("Entrando a consultar usuario");
        boolean respuesta = false;
        int contador = 0;
        personalDTO vacio = new personalDTO();
        while(contador<personal.size()){
            if(personal.get(contador).getId()==id){
                vacio=personal.get(contador);
                respuesta = true;
                break;
            }
            contador++;
        }

        objPersonal.value=vacio;
        return respuesta;  
    }


    
}
