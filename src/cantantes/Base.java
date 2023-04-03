/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static javax.management.Query.value;

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
                
                return;
                
            }
        }throw new IllegalArgumentException("La lista esta llena");
    }
    
    public void CrearCancion(String Nombre, ArrayList<Integer> CantantesID, long Ventas){
        
        for(int codigo = 100000; codigo < 1000000 ; codigo++){
            
            if(!ListaCanciones.containsKey(codigo)){
                
                Cancion nuevo = new Cancion(Nombre,CantantesID,Ventas); //añade los datos ingresados en el metodo a un objeto temporal
                ListaCanciones.put(codigo, nuevo); //añade el objeto a la lista de canciones
                
                for(Integer ob:CantantesID){ //divide los ids de los cantantes
                    
                    //ingresa el codigo de la cancion creada a cada cantante al que le pertenece
                    cantanteFamoso cantante = ListaCantantesFamosos.get(ob);
                    cantante.AñadirCancion(codigo);
                    ListaCantantesFamosos.replace(ob, cantante);
                    
                }
                return;
            }
        }throw new IllegalArgumentException("La lista esta llena");
    }
    public void CrearCancion(String Nombre, int CantanteID, long Ventas){
        ArrayList<Integer> CantantesID = new ArrayList<>();
        CantantesID.add(CantanteID);
        for(int codigo = 100000; codigo < 1000000 ; codigo++){
            
            if(!ListaCanciones.containsKey(codigo)){
                
                Cancion nuevo = new Cancion(Nombre,CantantesID,Ventas); //añade los datos ingresados en el metodo a un objeto temporal
                ListaCanciones.put(codigo, nuevo); //añade el objeto a la lista de canciones
                
                for(Integer ob:CantantesID){ //divide los ids de los cantantes
                    
                    //ingresa el codigo de la cancion creada a cada cantante al que le pertenece
                    cantanteFamoso cantante = ListaCantantesFamosos.get(ob);
                    cantante.AñadirCancion(codigo);
                    ListaCantantesFamosos.replace(ob, cantante);
                    
                }
                return;
            }
        }throw new IllegalArgumentException("La lista esta llena");
    }
    
    public void ModificarCantante(int codigo, String NuevoNombre){
        cantanteFamoso cantante = ListaCantantesFamosos.get(codigo);
        cantante.setNombre(NuevoNombre);
        ListaCantantesFamosos.replace(codigo, cantante);
    }
    
    public void BorrarCantante(int codigo){
        ArrayList<Integer> Canciones = ListaCantantesFamosos.get(codigo).getIDsCanciones();
        ListaCantantesFamosos.remove(codigo);
        for(int ob:Canciones){
            Cancion cancion= ListaCanciones.get(ob);
            cancion.BorrarCantante(codigo);
            ListaCanciones.replace(ob, cancion);
        }
    }
    
    public void ModificarCancion(int Codigo, String Nombre, long Ventas){
        Cancion cancion = ListaCanciones.get(Codigo);
        cancion.setNombre(Nombre);
        cancion.setVentas(Ventas);
        ListaCanciones.replace(Codigo, cancion);
    }
    
    public void BorrarCancion(int codigo){
        ArrayList<Integer> Cantantes = ListaCanciones.get(codigo).getIDsCantantes();
        ListaCanciones.remove(codigo);
        for(int ob:Cantantes){
            cantanteFamoso cantante= ListaCantantesFamosos.get(ob);
            cantante.BorrarCancion(codigo);
            ListaCantantesFamosos.replace(ob, cantante);
        }
    }
    
    public int VentasTotalesCantante(int Codigo){
        ArrayList<Integer> Canciones = ListaCantantesFamosos.get(Codigo).getIDsCanciones();
        int VentasTotales = 0;
        for(int ID:Canciones){
            VentasTotales += ListaCanciones.get(ID).getVentas();
        }
        return VentasTotales;
    }
    
    public Cancion DiscoMasVendidoDeCantante(int Codigo){
        cantanteFamoso cantante = ListaCantantesFamosos.get(Codigo);
        ArrayList<Integer> Canciones = cantante.getIDsCanciones();
        int IDMasVendido = Canciones.get(0);
        for(int ID:Canciones){
            if(ListaCanciones.get(IDMasVendido).getVentas() < ListaCanciones.get(ID).getVentas()){
                IDMasVendido = ID;
            }
        }
        return ListaCanciones.get(IDMasVendido);
    }
    
    public String toSringTabla(){
        Collection<cantanteFamoso> ColeccionCantantes = ListaCantantesFamosos.values();
        String str = "";
        
        for(cantanteFamoso cantante:ColeccionCantantes){
            String NombreCantante = cantante.getNombre();
            str += "- "+NombreCantante+"\n";
            ArrayList<Integer> CancionesCantanteIDs = cantante.getIDsCanciones();
            for(int cancionID:CancionesCantanteIDs){
                Cancion cancion = ListaCanciones.get(cancionID);
                String NombreCancion = cancion.getNombre();
                long VentasCancion = cancion.getVentas();
                
                str += "\t- "+NombreCancion+": $"+VentasCancion+"\n";
            }
        }
        return str;
    }
    
    public int BuscarCantante(String Nombre){
        for(Map.Entry<Integer, cantanteFamoso> entry:ListaCantantesFamosos.entrySet()){
            String NombreCantante = entry.getValue().getNombre();
            if(NombreCantante.equals(Nombre)){
                return entry.getKey();
            }
        }
        return -1;
    }
    
    public int BuscarCancion(String Nombre){
        for(Map.Entry<Integer, Cancion> entry:ListaCanciones.entrySet()){
            String NombreCancion = entry.getValue().getNombre();
            if(NombreCancion.equals(Nombre)){
                return entry.getKey();
            }
        }
        return -1;
    }

}
