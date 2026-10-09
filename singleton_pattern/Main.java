package singleton_pattern;

public class Main {
    public static void main(String[] args) {
        Connection connection1 = Connection.getConnectionLazily();
        Connection connection2 = Connection.getConnectionLazily();

        if(connection1.hashCode() == connection2.hashCode()){
            System.out.println("Both are same objects");
        }else{
            System.out.println("Both are different objects");
        }
        
        Connection connection3 = Connection.getConnectionEagerly();
        Connection connection4 = Connection.getConnectionEagerly();
        if(connection3.hashCode() == connection4.hashCode()){
            System.out.println("Both are same objects");
        }else{
            System.out.println("Both are different objects");
        }

    }
}
