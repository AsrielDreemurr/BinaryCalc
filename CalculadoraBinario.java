package calculadorabinario;

import java.util.Scanner;


public class CalculadoraBinario {
    boolean isThirtyTwo = true;
    boolean binaryInput = true;
   
    
    public int[] toArray (String a){
        String aux;
        int[] array;
        if (binaryInput==false){ 
            aux = Integer.toBinaryString(Integer.parseInt(a));
            array = new int[aux.length()];
            for (int i = 0; i < aux.length(); i++){ 
                array[i] = aux.charAt(i) - '0';                
            }
        }
        else{
            array = new int[a.length()];
            for (int i = 0; i < a.length(); i++){
                array[i] = a.charAt(i) - '0';
            }
        }
        
        
        return array;
    }
    
    public int normalizador(int[] a){
        StringBuilder temp = new StringBuilder();
        //System.out.println(a[2]+" "+a[1]+" "+a[0]);
        int retorno;
        
        for (int i = 0; i < a.length-1; i++) {
            if (a[i]>=2){
                a[i] = a[i]-2;
                a[i+1] = a[i+1]+1;
                
            }
        }
        //System.out.println(a[1]+" "+a[0]);
        
        for (int i = a.length; i > 0; i--) {
            temp.append(a[i-1]);
        }
        
        retorno = Integer.parseInt(temp.toString());
        return retorno;
    }
    
    public int somaBinario(String a, String b){
        int[] arrayA = toArray(a);
        int[] arrayB = toArray(b);
        int maior = Math.max(arrayA.length, arrayB.length);
        int[] resposta = new int[maior+1];
        
        for(int i =0;i<maior;i++){
            resposta[i]=arrayA[i]+arrayB[i];
            System.out.println(resposta[i]+" "+arrayA[i]+" "+arrayB[i]);
        }
        int fin = normalizador(resposta);
        return fin;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.next();
        String y = in.next();
        int r = 0;
        CalculadoraBinario calc = new CalculadoraBinario();
        
        r = calc.somaBinario(x, y);
        
        System.out.print(r);
        
       
    }
    
}
