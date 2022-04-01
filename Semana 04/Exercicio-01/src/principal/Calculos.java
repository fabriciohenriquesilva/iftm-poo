package principal;

public class Calculos {
    
    private float num1;
    private float num2;
    private float total;
    private float valor;
    private int x1;
    private int x2;
    private int x3;
    public Calculos(){
        num1 = 0;
        num2 = 0;
        total = 0;
        x1 = 17;
        x2 = 9;
        x3 = 2000;
        valor = x3 - (5 * x2 * x1);
    }
    public float getTotal(){
        return(total);
    }
    public void setNum1(float v1){
        num1 = v1;
    }
    public void setNum2(float v1){
        num2 = v1;
    }
    public float calc01(float v1, float v2){
        float res;
        res = ((v1 + v2) - 4) + valor;
        return(res);
    }
    public float calc02(){
        total = 4;
        for(int i = 0; i < 4; i++){
            num1++;
            num2 -= 3;
            if(i > 2)
                total += num1 + num2 - 3 + valor;
        }
        return(total);
    }
    
    public void calc03(){
        if(num2 < num1)
            total = valor - 2;
        else
            total = num1 - num2 - valor + 19;
    }    
}