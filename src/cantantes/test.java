/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cantantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author HP PORTATIL
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap <String, ListaCantantesFamosos> ConjuntoListas = new HashMap<>();
        ConjuntoListas.put("Introducidas", new ListaCantantesFamosos());
        
        ConjuntoListas = AñadirCantanteHash(ConjuntoListas,"Introducidas","Jorge Velosa", "Las Diabluras",1500000);
        ConjuntoListas = AñadirCantanteHash(ConjuntoListas,"Introducidas","Freddie Mercury", "Bohemian Rhapsody",2000000000);
        
        ActualizarListaPantalla(ConjuntoListas.get("Introducidas"));
        
        Scanner in=new Scanner (System.in);
        char op;
        
        do{
            System.out.print("""
                             ----------------------------------------------------MENU PRINCIPAL----------------------------------------------------
                             
                             1. Añadir Cantante
                             2. Modificar Nombre de cantante
                             3. Eliminar cantante
                             4. Mostrar Lista de ingresos
                             5. Mostrar Lista Ordenada por ventas
                             Para cerrar la ejecusion oprime 'Y'
                             
                             Ingresa uno de los caracteres presentados
                             --""");
            op=in.next().charAt(0);
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            in.nextLine();
            switch(op){
                case '1':
                    do{
                        System.out.print("Ingresa Nombre del cantante\n--");
                        String Nombre = in.nextLine();
                        System.out.print("Ingresa Disco con mas ventas\n--");
                        String DiscoConMasVentas = in.nextLine();
                        System.out.print("Ingresa ventas del Disco\n--");
                        long VentasDeDisco = in.nextLong();
                        
                        ConjuntoListas = AñadirCantanteHash(ConjuntoListas,"Introducidas",Nombre, DiscoConMasVentas, VentasDeDisco);
                        
                    }while(!repeat(op));
                    break;
                case '2':
                    do{
                        System.out.print("Ingresa Nombre Actual del cantante\n--");
                        String ANombre = in.nextLine();
                        if(!ConjuntoListas.get("Introducidas").ContieneCantante(ANombre)){
                            System.out.println("Este cantante no esta registrado");
                        }else{
                            System.out.print("Ingresa Nuevo Nombre del cantante\n--");
                            String NNombre = in.nextLine();
                            ConjuntoListas = ModificarCantanteHash(ConjuntoListas,"Introducidas",ANombre, NNombre);
                        }
                    }while(!repeat(op));
                    break;
                case '3':
                    do{
                        System.out.print("Ingresa Nombre del cantante\n--");
                        String Nombre = in.nextLine();
                        if(!ConjuntoListas.get("Introducidas").ContieneCantante(Nombre)){
                            System.out.println("Este cantante no esta registrado");
                        }else{
                            ConjuntoListas = BorrarCantanteHash(ConjuntoListas,"Introducidas",Nombre);
                        }
                    }while(!repeat(op));
                    break;
                case '4':
                    do{
                        ActualizarListaPantalla(ConjuntoListas.get("Introducidas"));
                    }while(!repeat(op));
                    break;
                case '5':
                    do{
                        ConjuntoListas = ListaOrdenada(ConjuntoListas);
                        ActualizarListaPantalla(ConjuntoListas.get("Ordenada"));
                    }while(!repeat(op));
                    break;
                case 'y': case 'Y':
                    System.out.println("PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("\033[31mLa informacion que ingresaste no es valido, por favor ingresa un caracter valido\033[0m");
                    break;
            }
        }while(op!='y'&&op!='Y');
        
    }
    
    
    public static void ActualizarListaPantalla(ListaCantantesFamosos Lista){
        ArrayList<cantanteFamoso> Alist = Lista.getListacantantesFamosos();
        
        for(int i = 0 ; i < Alist.size() ; i++){
            String Nombre = Alist.get(i).getNombre();
            String DiscoConMasVentas = Alist.get(i).getDiscoConMasVentas();
            long VentasDeDisco = Alist.get(i).getVentasDeDisco();
            
            System.out.println(DiscoConMasVentas+" - "+Nombre+"\n\tVentas: "+VentasDeDisco);
        }
    }
    
    private static HashMap <String, ListaCantantesFamosos> ListaOrdenada(HashMap <String, ListaCantantesFamosos> hash){
        HashMap <String, ListaCantantesFamosos> Hash = hash;
        
        if(!Hash.containsKey("Ordenada")){
            Hash.put("Ordenada", Hash.get("Introducidas").OrdenarLista());
        }else{
            Hash.replace("Ordenada", Hash.get("Introducidas").OrdenarLista());
        }
        
        return(Hash);
    }
    
    private static boolean repeat(char Operator){
        Scanner in=new Scanner (System.in);
        
        do{
            System.out.print("Preciona la letra 'N' para repetir la accion\nPreciona la letra 'M' para volver al menu\n-");
            Operator = in.next().charAt(0);
            if(Operator!='n'&&Operator!='N'&&Operator!='m'&&Operator!='M'){
                System.out.println("\n\033[31mLa informacion que ingresaste no es valido, por favor ingresa un caracter valido\033[0m\n");
            }
        }while(Operator!='n'&&Operator!='N'&&Operator!='m'&&Operator!='M');
        
        return Operator!='n'&&Operator!='N';
    }
    
    
    
    private static HashMap <String, ListaCantantesFamosos> AñadirCantanteHash(HashMap <String, ListaCantantesFamosos> hash, String key, String Nombre, String DiscoMasVendido, long VentasDisco){
        HashMap <String, ListaCantantesFamosos> Hash = hash;
        ListaCantantesFamosos Lista = Hash.get(key);
        Lista.AñadirCantanteFamoso(Nombre, DiscoMasVendido, VentasDisco);
        Hash.replace(key, Lista);
        
        return Hash;
    }
    
    private static HashMap <String, ListaCantantesFamosos> ModificarCantanteHash(HashMap <String, ListaCantantesFamosos> hash, String key, String ANombre, String NNombre){
        HashMap <String, ListaCantantesFamosos> Hash = hash;
        ListaCantantesFamosos Lista = Hash.get(key);
        Lista.modificarCantante(ANombre, NNombre);
        Hash.replace(key, Lista);
        
        return Hash;
    }
    
    private static HashMap <String, ListaCantantesFamosos> BorrarCantanteHash(HashMap <String, ListaCantantesFamosos> hash, String key, String Nombre){
        HashMap <String, ListaCantantesFamosos> Hash = hash;
        ListaCantantesFamosos Lista = Hash.get(key);
        Lista.borrarCantante(Nombre);
        Hash.replace(key, Lista);
        
        return Hash;
    }
}
