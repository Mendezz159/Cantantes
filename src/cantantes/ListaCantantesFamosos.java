/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantes;

import java.util.ArrayList;

/**
 *
 * @author HP PORTATIL
 */
public class ListaCantantesFamosos {
    private ArrayList<cantanteFamoso> listacantantesFamosos = new ArrayList<>();
    
    public void AñadirCantanteFamoso(String Nombre, String DiscoConMasVentas, long VentasDeDisco){
        cantanteFamoso NuevoCantante = new cantanteFamoso(Nombre, DiscoConMasVentas, VentasDeDisco);
        listacantantesFamosos.add(NuevoCantante);
    }

    public ListaCantantesFamosos(ArrayList<cantanteFamoso> listacantantesFamosos) {
        this.listacantantesFamosos = listacantantesFamosos;
    }
    
    public ListaCantantesFamosos() {
    }

    public ArrayList<cantanteFamoso> getListacantantesFamosos() {
        return listacantantesFamosos;
    }

    public void setListacantantesFamosos(ArrayList<cantanteFamoso> listacantantesFamosos) {
        this.listacantantesFamosos = listacantantesFamosos;
    }
    
    public boolean ContieneCantante(String Cantante){
        boolean Existente = false;
        
        for(cantanteFamoso ob: listacantantesFamosos){
            if(ob.getNombre().equals(Cantante)){
                Existente = true;
            }
        }
        
        return Existente;
    }
    
    public void modificarCantante(String NombreAntes, String NuevoNombre){
        for(cantanteFamoso ob: listacantantesFamosos){
            if(ob.getNombre().equals(NombreAntes)){
                ob.setNombre(NuevoNombre);
                listacantantesFamosos.set(ob.hashCode(), ob);
            }
        }
    }
    
    public void borrarCantante(String Nombre){
        for(cantanteFamoso ob: listacantantesFamosos){
            if(ob.getNombre().equals(Nombre)){
                listacantantesFamosos.remove(ob.hashCode());
            }
        }
    }
    
    public ListaCantantesFamosos OrdenarLista(ListaCantantesFamosos lista){
        ListaCantantesFamosos Lista = lista;
        if (Lista.getListacantantesFamosos().size() <= 1){
            return Lista;
        }
        
        int pivotIndex = Lista.getListacantantesFamosos().size()/2;
        long pivotValue = Lista.getListacantantesFamosos().get(pivotIndex).getVentasDeDisco(); //Lista.get(pivotIndex)
        
        ListaCantantesFamosos menores = new ListaCantantesFamosos();
        ListaCantantesFamosos mayores = new ListaCantantesFamosos();
        ListaCantantesFamosos iguales = new ListaCantantesFamosos();
        
        for (int i = 0; i < Lista.getListacantantesFamosos().size(); i++) {
            long value = Lista.getListacantantesFamosos().get(i).getVentasDeDisco();
            if (value < pivotValue) {
                menores.AñadirCantanteFamoso(Lista.getListacantantesFamosos().get(i).getNombre(), 
                                             Lista.getListacantantesFamosos().get(i).getDiscoConMasVentas(),
                                             value);
            } else if (value > pivotValue) {
                mayores.AñadirCantanteFamoso(Lista.getListacantantesFamosos().get(i).getNombre(), 
                                             Lista.getListacantantesFamosos().get(i).getDiscoConMasVentas(),
                                             value);
            } else {
                iguales.AñadirCantanteFamoso(Lista.getListacantantesFamosos().get(i).getNombre(), 
                                             Lista.getListacantantesFamosos().get(i).getDiscoConMasVentas(),
                                             value);
            }
        }

        mayores = OrdenarLista(mayores);
        menores = OrdenarLista(menores);
        
        ArrayList<cantanteFamoso> Listaordenado = new ArrayList<>();
        
        Listaordenado.addAll(mayores.getListacantantesFamosos());
        Listaordenado.addAll(iguales.getListacantantesFamosos());
        Listaordenado.addAll(menores.getListacantantesFamosos());
        
        ListaCantantesFamosos ordenado = new ListaCantantesFamosos();
        ordenado.setListacantantesFamosos(Listaordenado);
        
        return ordenado;
    }
    
    public ListaCantantesFamosos OrdenarLista(){
        
        ListaCantantesFamosos Lista = new ListaCantantesFamosos(this.listacantantesFamosos);
        
        if (Lista.getListacantantesFamosos().size() <= 1){
            return Lista;
        }
        
        int pivotIndex = Lista.getListacantantesFamosos().size()/2;
        long pivotValue = Lista.getListacantantesFamosos().get(pivotIndex).getVentasDeDisco(); //Lista.get(pivotIndex)
        
        ListaCantantesFamosos menores = new ListaCantantesFamosos();
        ListaCantantesFamosos mayores = new ListaCantantesFamosos();
        ListaCantantesFamosos iguales = new ListaCantantesFamosos();
        
        for (int i = 0; i < Lista.getListacantantesFamosos().size(); i++) {
            long value = Lista.getListacantantesFamosos().get(i).getVentasDeDisco();
            if (value < pivotValue) {
                menores.AñadirCantanteFamoso(Lista.getListacantantesFamosos().get(i).getNombre(), 
                                             Lista.getListacantantesFamosos().get(i).getDiscoConMasVentas(),
                                             value);
            } else if (value > pivotValue) {
                mayores.AñadirCantanteFamoso(Lista.getListacantantesFamosos().get(i).getNombre(), 
                                             Lista.getListacantantesFamosos().get(i).getDiscoConMasVentas(),
                                             value);
            } else {
                iguales.AñadirCantanteFamoso(Lista.getListacantantesFamosos().get(i).getNombre(), 
                                             Lista.getListacantantesFamosos().get(i).getDiscoConMasVentas(),
                                             value);
            }
        }

        mayores = OrdenarLista(mayores);        
        menores = OrdenarLista(menores);
        
        ArrayList<cantanteFamoso> Listaordenado = new ArrayList<>();
        
        Listaordenado.addAll(mayores.getListacantantesFamosos());
        Listaordenado.addAll(iguales.getListacantantesFamosos());
        Listaordenado.addAll(menores.getListacantantesFamosos());
        
        ListaCantantesFamosos ordenado = new ListaCantantesFamosos();
        ordenado.setListacantantesFamosos(Listaordenado);
        
        return ordenado;
    }
}
