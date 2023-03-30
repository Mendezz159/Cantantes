/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cantantes;

import java.util.ArrayList;
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
        ListaCantantesFamosos Lista1 = new ListaCantantesFamosos();
        
        Lista1.AñadirCantanteFamoso("Freddie Mercury", "Bohemian Rhapsody");
        Lista1.AñadirCantanteFamoso("Jorge Velosa", "Las Diabluras");
        
        ActualizarListaPantalla(Lista1);
        
        Scanner in=new Scanner (System.in);
        char op;
        
        do{
            System.out.print("----------------------------------------------------MENU PRINCIPAL----------------------------------------------------"+
                             "\n"+
                             "\n1. Añadir Cantante"+
                             "\n2. Modificar Nombre de cantante"+
                             "\n3. Eliminar cantante"+
                             "\nPara cerrar la ejecusion oprime 'Y'"+
                             "\n"+
                             "\nIngresa uno de los caracteres presentados"+
                             "\n--");
                            
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
                        
                        Lista1.AñadirCantanteFamoso(Nombre, DiscoConMasVentas);
                        ActualizarListaPantalla(Lista1);
                    }while(!repeat(op));
                    break;
                case '2':
                    do{
                        System.out.print("Ingresa Nombre Actual del cantante\n--");
                        String ANombre = in.nextLine();
                        if(!Lista1.ContieneCantante(ANombre)){
                            System.out.println("Este cantante no esta registrado");
                        }else{
                            System.out.print("Ingresa Nuevo Nombre del cantante\n--");
                            String NNombre = in.nextLine();
                            Lista1.modificarCantante(ANombre, NNombre);
                        }
                        ActualizarListaPantalla(Lista1);
                    }while(!repeat(op));
                    break;
                case '3':
                    do{
                        System.out.print("Ingresa Nombre del cantante\n--");
                        String Nombre = in.nextLine();
                        if(!Lista1.ContieneCantante(Nombre)){
                            System.out.println("Este cantante no esta registrado");
                        }else{
                            Lista1.borrarCantante(Nombre);
                        }
                        ActualizarListaPantalla(Lista1);
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
            
            System.out.println("Cantante: "+Nombre+" ; Disco Mas Vendido: "+DiscoConMasVentas);
        }
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
}
