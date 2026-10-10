package singleton_pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Connection connection1 = Connection.getConnectionLazily();
        Connection connection2 = Connection.getConnectionLazily();

        if (connection1.hashCode() == connection2.hashCode()) {
            System.out.println("Both are same objects");
        } else {
            System.out.println("Both are different objects");
        }

        Connection connection3 = Connection.getConnectionEagerly();
        Connection connection4 = Connection.getConnectionEagerly();
        if (connection3.hashCode() == connection4.hashCode()) {
            System.out.println("Both are same objects");
        } else {
            System.out.println("Both are different objects");
        }

        // below are the approaches to break the pattern

        // through refelction
        Constructor<Connection> constructor = Connection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Connection connection6 = constructor.newInstance();
        Connection connection7 = constructor.newInstance();
        System.out.println(connection6.hashCode() == connection7.hashCode() ? "same instance" : "not same instance");
    }
}
