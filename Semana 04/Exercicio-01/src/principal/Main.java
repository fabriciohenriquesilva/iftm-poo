package principal;

public class Main {

	public static void main(String[] args) {
		Calculos ca;
        ca = new Calculos();
        
        float valor1 = 5, 
              valor2 = 9, 
              resultado = 0;
        
        int i = 2;
        while(i < 5){
            resultado += ca.calc01(valor1, i);
            i++;
        }
        System.out.println("\n\nResultado - calc01: " + resultado);
        
        ca.setNum1(valor1);
        ca.setNum2(valor2);
        resultado = ca.calc02();
        System.out.println("\n\nResultado - calc02: " + resultado);
        
        ca.setNum1(valor1);
        ca.setNum2(valor2);
        ca.calc03();
        resultado = ca.getTotal();
        System.out.println("\n\nResultado - calc03: " + resultado);
        
        ca.setNum1(resultado);
        ca.setNum2(10);
        ca.calc03();
        resultado = ca.getTotal();
        System.out.println("\n\nResultado - calc04: " + resultado);
        
        ca.setNum1(10);
        ca.setNum2(9);
        ca.calc02();
        resultado = ca.getTotal();
        System.out.println("\n\nResultado - calc05: " + resultado);
    }

}
