/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Practica
 */
public class Base {
    
    private HashMap<Integer,cantanteFamoso> ListaCantantesFamosos = new HashMap<>();
    private HashMap<Integer,Cancion> ListaCanciones = new HashMap<>();
    
    public void CrearCantante(String Nombre){
        
        for(int codigo = 100000; codigo < 1000000 ; codigo++){
            if(!ListaCantantesFamosos.containsKey(codigo)){
                cantanteFamoso nuevo = new cantanteFamoso(Nombre);
                ListaCantantesFamosos.put(codigo, nuevo);
            }
        }
        throw new IllegalArgumentException("La lista esta llena");
    }
    
    public void CrearCancion(String Nombre, ArrayList<Integer> CantantesID, int Ventas){
        
        for(int codigo = 100000; codigo < 1000000 ; codigo++){
            if(!ListaCanciones.containsKey(codigo)){
                Cancion nuevo = new Cancion(Nombre,CantantesID,Ventas);
                ListaCanciones.put(codigo, nuevo);
                for(Integer ob:CantantesID){
                    cantanteFamoso cantante = ListaCantantesFamosos.get(ob);
                    cantante.AñadirCancion(codigo);
                    ListaCantantesFamosos.replace(ob, cantante);
                }
            }
        }
        throw new IllegalArgumentException("La lista esta llena");
    }
    
    public void ModificarCantante(int codigo, String NuevoNombre){
        cantanteFamoso cantante = ListaCantantesFamosos.get(codigo);
        cantante.setNombre(NuevoNombre);
        ListaCantantesFamosos.replace(codigo, cantante);
    }
    
    public void BorrarCantante(int codigo){
        
    }
    
    public void ModificarCancion(int Codigo, String Nombre, int Ventas){
        
    }
    
    public void BorrarCancion(int Codigo){
        
    }
    
    public int VentasTotalesCantante(int Codigo){
        
        return 0;
    }
    
    public Cancion DiscoMasVendidoDeCantante(int Codigo){
        
        return null;
    }
}
