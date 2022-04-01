package principal;

public class Main {

	public static void main(String[] args) {
		Calculos ca;
        ca = new Calculos();
        
        float valor1 = 0, 
              valor2 = 1, 
              resultado = 0;
        
        int i = 0;
        do{
            resultado += ca.calc01(valor1, i + 3);
            i++;
        }while(i < 3);
        
        System.out.println("\n\nResultado - calc01: " + resultado);
        
        ca.setNum1(valor1 + 1);
        ca.setNum2(valor2 - 10);
        resultado = ca.calc02();
        System.out.println("\n\nResultado - calc02: " + resultado);
        
        ca.setNum1(valor1 - valor2);
        ca.setNum2(valor2 - valor1);
        ca.calc03();
        resultado = 100 - ca.getTotal();
        System.out.println("\n\nResultado - calc03: " + resultado);
        
        ca.setNum1(resultado);
        ca.setNum2(15);
        ca.calc03();
        resultado = ca.getTotal();
        System.out.println("\n\nResultado - calc04: " + resultado);
        
        ca.setNum1(1);
        ca.setNum2(90);
        ca.calc02();
        resultado = ca.getTotal();
        System.out.println("\n\nResultado - calc05: " + resultado);
        
	}

}
