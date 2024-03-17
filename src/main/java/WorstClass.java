import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class WorstClass {


    // Vulnerabilidad 1: Inyección SQL
    public boolean login(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Vulnerabilidad 2: Uso de Dependencias Desactualizadas
    // Supongamos que estamos utilizando una biblioteca con una vulnerabilidad conocida.

    // Vulnerabilidad 3: Falta de Validación de Entrada
    public void processUserInput(String userInput) {
        // Esto podría ser vulnerable a ataques de scripting cross-site (XSS).
        System.out.println("Usuario dice: " + userInput);
    }

    public static void main(String[] args) {
        WorstClass example = new WorstClass();

        // Ejemplo de Inyección SQL
        boolean authenticated = example.login("admin' OR '1'='1' --", "password123");
        System.out.println("Login exitoso: " + authenticated);

        // Ejemplo de Uso de Dependencias Desactualizadas
        // Supongamos que estamos utilizando una biblioteca con una vulnerabilidad conocida.

        // Ejemplo de Falta de Validación de Entrada
        example.processUserInput("<script>alert('XSS');</script>");
    }
}
