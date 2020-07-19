import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Por favor ingrese la dimensión de su cuadrado mágico IMPAR:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] cuadrado = new int[n][n];

        //llenar la casilla central de la primera columna con un un 1
        int cont = 1;
        int r = 0;
        int c = n/2; //si n=5 5/2=2.5 entonces tomaria 2 y como hablamos de posiciones, esta es la de la mitad.
        cuadrado[r][c] = cont;

        cont++;
        while(cont != (n*n)+1){
            if((cont-1)%n == 0){ //regla numero 3 (v)
                r = r+1;
                cuadrado[r][c] = cont;
                cont++;
            }else{ //regla numero 2  (-> ^)

                if(r==0||c==n-1){ //si estan en el limite
                    if(r==0 && c==(n-1)){
                        System.out.println("El numero que ingresaste es par, este cuadrado no cumple!!");
                    }else{
                        if(r==0){
                            r = n-1;
                            c = c+1;
                        }else{
                            c = 0;
                            r = r-1;
                        }
                    }

                }else{
                    r = r-1;
                    c = c+1;
                }

                cuadrado[r][c] = cont;
                cont++;
            }
        }



        System.out.println("Aqui está tu cuadrado mágico:\n");

        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[0].length; j++) {
                System.out.print(cuadrado[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
