import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ArrayList<String> proveedores = new ArrayList<>();
        ArrayList<String> ciudad = new ArrayList<>();
        ArrayList<Integer> numeroDeArticulos = new ArrayList<>();

        //agregando la informacion de proveedores iniciales
        proveedores.add("Angela");
        ciudad.add("Piedecuesta");
        numeroDeArticulos.add(3);

        proveedores.add("Maria");
        ciudad.add("Bucaramanga");
        numeroDeArticulos.add(5);

        boolean flag = true;

        Scanner scan = new Scanner(System.in);

        System.out.println("Hola! bienvenido a nuestro sistema ¿Que quieres hacer?");
        while (flag){

            System.out.println("Presiona la opción que quieras realizar");
            System.out.println("1. Ver la infomación de un proveedor");
            System.out.println("2. Actualizar el domicilio de un proveedor");
            System.out.println("3. Actualizar el numero de articulos de un proveedor");
            System.out.println("4. Agregar un nuevo proveedor");
            System.out.println("5. Dar de baja a un proveedor");
            System.out.println("6. Salir del menú");

            int res = Integer.parseInt(scan.nextLine());

            switch (res){
                case 1:
                    System.out.println("Ingresa el nombre del proveedor:");
                    String nombreInfo = scan.nextLine();
                    int indexInfo = proveedores.indexOf(nombreInfo);
                    System.out.println("Ciudad de residencia de "+nombreInfo+": "+ciudad.get(indexInfo));
                    System.out.println("Numero de articulos que provee "+nombreInfo+": "+numeroDeArticulos.get(indexInfo));
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del proveedor:");
                    String nombreDom = scan.nextLine();
                    int indexDom = proveedores.indexOf(nombreDom);

                    System.out.println("Ahora ingresa la nueva ciudad de residencia de este proveedor");
                    String newCiudad = scan.nextLine();
                    ciudad.set(indexDom,newCiudad);

                    System.out.println("Listo, esta es la nueva información del proovedor "+nombreDom);
                    System.out.println("Ciudad nueva de residencia de "+nombreDom+": "+ciudad.get(indexDom));
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("Ingresa el nombre del proveedor:");
                    String nombreNum = scan.nextLine();
                    int indexNum = proveedores.indexOf(nombreNum);
                    int oldNumArticulos = numeroDeArticulos.get(indexNum);
                    System.out.println("Ahora ingresa cuantos articulos provee ahora el proveedor:");
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
                    System.out.println("Ingresa los datos del nuevo proveedor a continuación:");
                    System.out.println("Nombre:");
                    String nombreNew = scan.nextLine();
                    proveedores.add(nombreNew);

                    System.out.println("Ciudad:");
                    String ciudadNew = scan.nextLine();
                    ciudad.add(ciudadNew);

                    System.out.println("Numero de articulos:");
                    int numArticulosNew = Integer.parseInt(scan.nextLine());
                    numeroDeArticulos.add(numArticulosNew);

                    System.out.println("Listo, esta es la información del nuevo proovedor: ");
                    int indexNew = proveedores.indexOf(nombreNew);
                    System.out.println("Nombre: "+proveedores.get(indexNew));
                    System.out.println("Ciudad: "+ciudad.get(indexNew));
                    System.out.println("Numero de articulos: "+numeroDeArticulos.get(indexNew));
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Ingresa el nombre del proveedor que quiera dar de baja:");
                    String nombreBaja = scan.nextLine();
                    int indexBaja = proveedores.indexOf(nombreBaja);

                    proveedores.remove(indexBaja);
                    ciudad.remove(indexBaja);
                    numeroDeArticulos.remove(indexBaja);

                    System.out.println("Listo, el proveedor " +nombreBaja+" fue eliminado.");
                    System.out.println("\n");

                    break;
                case 6:
                    System.out.println("Hasta luego!");
                    flag=false;
                    break;
                default:
                    System.out.println("Esa no es una opción, intenta de nuevo");
            }

        }

    }


}
