package Class3.SimplyFactory;

/**
 * Created by FLK on 2020-09-19.
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult(double number1, double number2) {
        return number1 + number2;
    }
}
