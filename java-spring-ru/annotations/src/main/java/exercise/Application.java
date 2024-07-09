package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        for (Method method: Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var methodName = method.getName();
                String[] typeOfReturnsValue = method.getReturnType().toString().split("\\.");
                var type = typeOfReturnsValue[typeOfReturnsValue.length - 1];
                System.out.println("Method " + methodName +
                        " returns a value of type " + type);
            }
        }
    }
}
