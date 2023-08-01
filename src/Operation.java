
import java.time.LocalDateTime;

public class Operation {
    double num1,num2,result;
    String type;
    LocalDateTime date;

    public Operation(double num1, double num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public Operation(double num1,String type, double num2, double result, LocalDateTime date) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.type = type;
        this.date=date;
    }

    public Operation() {
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Result ["+
                getNum1()+
                " "+getType()+
                " "+getNum2()+
                " = "+getResult()+
                " ... "+getDate()+
                "]";
    }
}
