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

    private static Base base = new Base();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        base.CrearCantante("Freddie Mercury");
        base.CrearCantante("Jorge Velosa");
        
        base.CrearCancion("Las Diabluras", base.BuscarCantante("Jorge Velosa"), 1500000);
        
        Scanner in=new Scanner (System.in);
        char op;
        
        do{
            System.out.print("----------------------------------------------------MENU PRINCIPAL----------------------------------------------------"+
                             "\n"+
                             "\n1. Añadir Cantante"+
                             "\n2. Añadir Cancion"+
                             "\n3. Modificar cantante"+
                             "\n4. Modificar Cancion"+
                             "\n5. Eliminar cantante"+
                             "\n6. Eliminar cancion"+
                             "\n7. Mostrar ventas de un cantante"+
                             "\n8. Mostrar disco mas vendido de un cantante"+
                             "\n9. Mostrar todos los cantantes y discos"+
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
                        
                        base.CrearCantante(Nombre);
                    }while(!repeat(op));
                    break;
                case '2':
                    do{

                        System.out.print("Ingresa Nombre de la cancion\n--");
                        String Nombre = in.nextLine();
                        
                        ArrayList IDsCantantes = CrearArrayCantantes();
                        
                        System.out.print("Ingresa el numero de Ventas\n--");
                        long Ventas = in.nextLong();
                        
                        base.CrearCancion(Nombre, IDsCantantes, Ventas);
                    }while(!repeat(op));
                    break;
                case '3':
                    do{
                        System.out.print("Ingresa Nombre Actual del cantante\n--");
                        String ANombre = in.nextLine();
                        
                        int CodigoCantante = base.BuscarCantante(ANombre);
                        boolean CantanteRegistrado = CodigoCantante != -1;
                        if(!CantanteRegistrado){
                            System.out.println("No se encontro el nombre del cantante, puebe cambiar las mayuscular");
                        }else{
                            System.out.print("Ingresa Nuevo Nombre del cantante\n--");
                            String NNombre = in.nextLine();
                            base.ModificarCantante(CodigoCantante, NNombre);
                        }
                    }while(!repeat(op));
                    break;
                case '4':
                    do{
                        System.out.print("Ingresa Nombre Actual de la cancion\n--");
                        String ANombre = in.nextLine();
                        
                        int CodigoCancion = base.BuscarCancion(ANombre);
                        boolean CancionRegistrada = CodigoCancion != -1;
                        if(!CancionRegistrada){
                            System.out.println("No se encontro el nombre de la cancion, puebe cambiar las mayuscular");
                        }else{
                            System.out.print("Ingresa Nuevo Nombre de la cancion\n--");
                            String NNombre = in.nextLine();
                            System.out.print("Ingresa Nuevo Numero de ventas\n--");
                            long Ventas = in.nextLong();
                            
                            base.ModificarCancion(CodigoCancion, NNombre, Ventas);
                        }
                    }while(!repeat(op));
                    break;
                case '5':
                    do{
                        System.out.print("Ingresa Nombre del cantante\n--");
                        String Nombre = in.nextLine();
                        
                        int CodigoCantante = base.BuscarCantante(Nombre);
                        boolean CantanteRegistrado = CodigoCantante != -1;
                        if(!CantanteRegistrado){
                            System.out.println("No se encontro el nombre del cantante, puebe cambiar las mayuscular");
                        }else{
                            base.BorrarCantante(CodigoCantante);
                        }
                    }while(!repeat(op));
                    break;
                case '6':
                    do{
                        System.out.print("Ingresa Nombre de la cancion\n--");
                        String Nombre = in.nextLine();
                        
                        int CodigoCancion = base.BuscarCancion(Nombre);
                        boolean CancionRegistrada = CodigoCancion != -1;
                        if(!CancionRegistrada){
                            System.out.println("No se encontro el nombre de la cancion, puebe cambiar las mayuscular");
                        }else{
                            base.BorrarCancion(CodigoCancion);
                        }
                    }while(!repeat(op));
                    break;
                case '7':
                    do{
                        System.out.print("Ingresa Nombre del cantante\n--");
                        String NombreCantante = in.nextLine();
                        
                        int CodigoCantante = base.BuscarCantante(NombreCantante);
                        boolean CantanteRegistrado = CodigoCantante != -1;
                        if(!CantanteRegistrado){
                            System.out.println("No se encontro el nombre del cantante, puebe cambiar las mayuscular");
                        }else{
                            int Ventas = base.VentasTotalesCantante(CodigoCantante);
                            System.out.println("\nLas ventas de "+NombreCantante+" dan un total de $"+Ventas+"\n");
                        }
                    }while(!repeat(op));
                    break;
                case '8':
                    do{
                        System.out.print("Ingresa Nombre del cantante\n--");
                        String NombreCantante = in.nextLine();
                        
                        int CodigoCantante = base.BuscarCantante(NombreCantante);
                        boolean CantanteRegistrado = CodigoCantante != -1;
                        if(!CantanteRegistrado){
                            System.out.println("No se encontro el nombre del cantante, puebe cambiar las mayuscular");
                        }else{
                            Cancion DiscoMasVendido = base.DiscoMasVendidoDeCantante(CodigoCantante);
                            String NombreDisco = DiscoMasVendido.getNombre();
                            long VentasDisco = DiscoMasVendido.getVentas();
                            
                            System.out.println("\nEl disco mas vendido de "+NombreCantante+" es "+NombreDisco+" con $"+VentasDisco+"\n");
                        }
                    }while(!repeat(op));
                    break;
                case '9':
                    do{
                        String Tabla = base.toSringTabla();
                        System.out.println(Tabla);
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
    
    private static ArrayList<Integer> CrearArrayCantantes(){
        Scanner in=new Scanner (System.in);
        ArrayList<Integer> IDsCantantes = new ArrayList<>();
        
        System.out.print("Ingresa Cuantos cantantes participaron en este disco\n--");
        int CantidadCantantes = in.nextInt();
        
        in.nextLine();
        for(int i=0;i<CantidadCantantes;i++){
            var repetir = false;
            do{
                System.out.print("Ingresa Nombre del cantante\n--");
                String Nombre = in.nextLine();

                int CodigoCantante = base.BuscarCantante(Nombre);
                if(CodigoCantante == -1){
                    System.out.println("No se encontro el nombre del cantante, puebe cambiar las mayuscular");
                    repetir=true;
                }else{
                    IDsCantantes.add(CodigoCantante);
                }
            }while(repetir);
        }
        return IDsCantantes;
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
