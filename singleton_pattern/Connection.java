package singleton_pattern;

// this is the class whose instance should be shared among all objects
// and each object shouldn't have its own copy
public class Connection {
    
    private static Connection connection;
    private static Connection eagerConnection = new Connection();

    private Connection(){
        if(connection != null){
            throw new RuntimeException("trying to break singleton pattern"); // this prevents breaking of the pattern by reflection
        }
    }

    // lazy approach --> problematic in multi threading without synchornization
    public static Connection getConnectionLazily(){
        if(connection == null){
            System.out.println("Connection object created");
            return connection = new Connection();
        }
        return connection;
    }

    // eager approach
    public static Connection getConnectionEagerly(){
        return eagerConnection;
    }

}
