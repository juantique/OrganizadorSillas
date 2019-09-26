import java.util.Scanner;
public class mesasfamilia{
 private static Scanner entrada = new Scanner(System.in);

 public static void main(String args[]){
  System.out.println("Organizador de Familias");
  int intNumFamilias = F_NumeroFamilias();
  int[] a = F_NumeroHijosFamilia(intNumFamilias);
  int k = F_NumeroMesas();
  int intNumeroFormas = contarFormas(a, k);
 }

 public static int F_NumeroFamilias(){
  System.out.println("Ingresa el numero de familias en la fiesta de cumpleaños:");
  int intFamilias = entrada.nextInt();
  while (intFamilias < 1 || intFamilias > 1000){
   System.out.println("El numero de Familias debe ser entre 1 y 1000:");
   System.out.println("Ingresa el numero de familias en la fiesta de cumpleaños:");
   intFamilias = entrada.nextInt();
  }
  return intFamilias;
 }

 public static int[] F_NumeroHijosFamilia(int intNumFamilias){
  int arrayHijosFamilia[] = new int[intNumFamilias];
  int intRecorreTotalFamilias = 0;
  int intHijosFamilia = 0;
  System.out.println("Ingresa el numero de Hijos por cada familia:");
  while (intRecorreTotalFamilias < arrayHijosFamilia.length){
   System.out.println("No. de Hijos familia: " + (intRecorreTotalFamilias + 1));
   intHijosFamilia = entrada.nextInt();
   while (intHijosFamilia < 1 || intHijosFamilia > 1000){
    System.out.println("El numero de Hijos por cada Familia debe ser entre 1 y 1000:");
    System.out.println("No. de Hijos familia: " + (intRecorreTotalFamilias + 1));
    intHijosFamilia = entrada.nextInt();
   }
   arrayHijosFamilia[intRecorreTotalFamilias] = intHijosFamilia;
   intRecorreTotalFamilias++;
  }
  return arrayHijosFamilia;
 }

 public static int F_NumeroMesas(){
  System.out.println("Ingresa el numero de mesas:");
  int intMesas = entrada.nextInt();
  while (intMesas < 1 || intMesas > 1000){
   System.out.println("El numero de mesas debe ser entre 1 y 1000:");
   System.out.println("Ingresa el numero de mesas:");
   intMesas = entrada.nextInt();
  }
  return intMesas;
 }

 public static int contarFormas(int[] a, int k){
  int intPotenciaFamilia = 0, intCombinacion = 1, intAuxFamilias = 0, intAux1 = 0, intAux2 = 1, intAux3 = 1, intAux4 = 0;

  for (int intRecorreTotalFamilias = 0; intRecorreTotalFamilias < a.length; intRecorreTotalFamilias++) {
   intPotenciaFamilia = (int) Math.pow(2, a[intRecorreTotalFamilias]);
   intCombinacion = intCombinacion * intPotenciaFamilia;
  }

  //(2 familias para 1 mesa)
  if(a.length > k){
   intAuxFamilias = a.length;
   intAux1 = intAuxFamilias - k;
   while(intAuxFamilias != 0){
    intAux2 = intAux2 * intAuxFamilias;
    intAuxFamilias--;
   }
   while(intAux1 != 0){
    intAux3 = intAux3 * intAux1;
    intAux1--;
   }
   intAux4 = intAux2/intAux3;
   intCombinacion = (intCombinacion * 2) + intAux4;
  }
  else{
   //(2 familias para 50 mesas)
   intAux1 = a.length - 1;
   intCombinacion = (intCombinacion + intAux1) * k;
  }

  System.out.println("COMBINACIONES: " + intCombinacion);
  return intCombinacion;
 }

}

