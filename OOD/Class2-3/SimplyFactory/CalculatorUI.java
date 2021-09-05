package Class3.SimplyFactory;

/**
 * Created by FLK on 2020-09-19.
 */
public class CalculatorUI {

    public double calculateDouble(final double number1, final String operate, final double number2) {


        final OperationFactory operationFactory = new OperationFactory();

        final Operation operation = operationFactory.createOperation(operate);



        return operation.getResult(number1, number2);

    }
}
