import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Antes de iniciar defina el máximo de proveedores que el sistema recibirá");
        int n = Integer.parseInt(scan.nextLine());

        String[] proveedores = new String[n];
        String[] ciudad = new String[n];
        int[] numeroDeArticulos =  new int[n];

        //agregando la informacion de proveedores iniciales
        proveedores[0] = "Angela";
        ciudad[0] = "Piedecuesta";
        numeroDeArticulos[0] = 3;

        proveedores[1] = "Maria";
        ciudad[1] = "Bucaramanga";
        numeroDeArticulos[1] = 5;

        boolean flag = true;
        int maxIndex = calcularMax(proveedores);

        System.out.println("Hola! bienvenido a nuestro sistema ¿Que quieres hacer?");
        while (flag){

            System.out.println("Presiona la opción que quieras realizar");
            System.out.println("1. Ver la infomación de un proveedor");
            System.out.println("2. Actualizar el domicilio de un proveedor");
            System.out.println("3. Actualizar el numero de articulos de un proveedor");
            System.out.println("4. Agregar un nuevo proveedor");
            System.out.println("5. Dar de baja a un proveedor");
            System.out.println("6. Salir del menú");
            System.out.println("7. Ver la lista de proveedores");

            int res = Integer.parseInt(scan.nextLine());

            switch (res){
                case 1:
                    System.out.println("Ingresa el nombre del proveedor:");
                    String nombreInfo = scan.nextLine();

                    int indexInfo = buscarEnArray(nombreInfo,proveedores);

                    if(indexInfo == -1){
                        System.out.println("El proovedor que usted busca no se encuentra en nuestros registros");
                    }else{
                        System.out.println("Ciudad de residencia de "+nombreInfo+": "+ciudad[indexInfo]);
                        System.out.println("Numero de articulos que provee "+nombreInfo+": "+numeroDeArticulos[indexInfo]);
                        System.out.println("\n");
                    }
                    break;

                case 2:
                    System.out.println("Ingresa el nombre del proveedor:");
                    String nombreDom = scan.nextLine();

                    int indexDom = buscarEnArray(nombreDom,proveedores);

                    System.out.println("Ahora ingresa la nueva ciudad de residencia de este proveedor");
                    String newCiudad = scan.nextLine();
                    ciudad[indexDom] = newCiudad;


                    System.out.println("Listo! \nLa nueva ciudad de residencia de "+nombreDom+" es: "+ciudad[indexDom]);
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("Ingresa el nombre del proveedor:");
                    String nombreNum = scan.nextLine();
                    int indexNum = buscarEnArray(nombreNum,proveedores);

                    int oldNumArticulos = numeroDeArticulos[indexNum];

                    System.out.println("Ingresa cuantos articulos provee ahora el proveedor:");
                    int newNumArticulos = Integer.parseInt(scan.nextLine());

                    if(oldNumArticulos>newNumArticulos){//-
                        System.out.println("El numero de articulos de "+nombreNum+" disminuyeron en "+(oldNumArticulos-newNumArticulos));
                    }else if(oldNumArticulos<newNumArticulos){//+
                        System.out.println("El numero de articulos de "+nombreNum+" aumentaron en "+(newNumArticulos-oldNumArticulos));
                    }else{//=
                        System.out.println("El proveedor "+nombreNum+" sigue provisionando el mismo numero de articulos");
                    }

                    System.out.println("Nuevo numero de articulos: "+ newNumArticulos );
                    System.out.println("\n");
                    break;

                case 4:


                    borrarVaciosString(proveedores);
                    borrarVaciosString(ciudad);
                    borrarVaciosint(numeroDeArticulos);

                    maxIndex = calcularMax(proveedores);
                    if(maxIndex==proveedores.length){
                        System.out.println("Ya no puedes agregar más proovedores, llegaste al maximo");

                    }else{
                        System.out.println("Ingresa los datos del nuevo proveedor a continuación:");

                        System.out.println("Nombre:");
                        String nombreNew = scan.nextLine();
                        proveedores[maxIndex] = nombreNew;

                        System.out.println("Ciudad:");
                        String ciudadNew = scan.nextLine();
                        ciudad[maxIndex] = ciudadNew;

                        System.out.println("Numero de articulos:");
                        int numArticulosNew = Integer.parseInt(scan.nextLine());
                        numeroDeArticulos[maxIndex] = numArticulosNew;

                        System.out.println("Listo, esta es la información del nuevo proovedor: ");
                        int indexNew = buscarEnArray(nombreNew,proveedores);
                        System.out.println("Nombre: "+proveedores[indexNew]);
                        System.out.println("Ciudad: "+ciudad[indexNew]);
                        System.out.println("Numero de articulos: "+numeroDeArticulos[indexNew]);
                        System.out.println("\n");

                    }

                    break;

                case 5:

                    System.out.println("Ingresa el nombre del proveedor que quiera dar de baja:");
                    String nombreBaja = scan.nextLine();
                    int indexBaja = buscarEnArray(nombreBaja,proveedores);

                    proveedores[indexBaja] = null;
                    ciudad[indexBaja] = null;
                    numeroDeArticulos[indexBaja] = 0;

                    System.out.println("Listo, el proveedor " +nombreBaja+" fue eliminado.");
                    System.out.println("\n");

                    borrarVaciosString(proveedores);
                    borrarVaciosString(ciudad);
                    borrarVaciosint(numeroDeArticulos);

                    break;

                case 6:
                    System.out.println("Hasta luego!");
                    flag=false;
                    break;
                case 7:
                    for (String prov:proveedores) {
                        System.out.println(prov);
                    }
                    break;
                
                default:

                    System.out.println("Esa no es una opción, intenta de nuevo");
                    System.out.println("\n");
            }
        }
    }
    public static int buscarEnArray(Object x, Object[] array){
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if(x.equals(array[i])){
                index = i;
                break;
            }
        }
        return index;
    }

    public static String[] borrarVaciosString(String[] array){

        int emptyIndex = -2;
        for (int i = 0; i < array.length ; i++) {

            if(array[i]==null){ // si está vacio ese espacio

                if(emptyIndex==-2){
                    emptyIndex = i;
                }

            }else{ //si está lleno ese espacio
                if(emptyIndex != -2){ //si sigue siendo -2 no hay que mover nada porque no hay un vacio antes, de lo contrario...v
                    String actual = array[i];
                    array[emptyIndex] =actual;
                    array[i]=null;
                    emptyIndex = emptyIndex+1; //lo acabo de dejar vacio
                }
            }
        }
        return array;
    }

    public static int[] borrarVaciosint(int[] array){

        int emptyIndex = -2;
        for (int i = 0; i < array.length ; i++) {

            if(array[i]==0){ // si está vacio ese espacio

                if(emptyIndex==-2){
                    emptyIndex = i;
                }

            }else{ //si está lleno ese espacio
                if(emptyIndex != -2){ //si sigue siendo -2 no hay que mover nada porque no hay un vacio antes, de lo contrario...v
                    int actual = array[i];
                    array[emptyIndex] =actual;
                    array[i]=0;
                    emptyIndex = emptyIndex+1; //lo acabo de dejar vacio
                }
            }
        }
        return array;
    }

    public static int calcularMax(String[] array){
        int max = array.length;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==null){
                max = i;
                break;
            }
        }

        return max;
    }
}
