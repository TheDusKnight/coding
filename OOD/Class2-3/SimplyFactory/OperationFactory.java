package Class3.SimplyFactory;

/**
 * Created by FLK on 2020-09-19.
 */
public class OperationFactory {

    public Operation createOperation(final String operate) {

        switch (operate) {
            case "+":
                return new OperationAdd();
            case "-":
                return new OperationSub();
            case "*" :
                return new OperationMulti();
            case "/" :
                return new OperationDiv();

        }

        return null;
    }
}
