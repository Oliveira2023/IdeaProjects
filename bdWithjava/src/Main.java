import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Efetuando busca no banco de dados...");

        ConexaoBD conexaoDB = new ConexaoBD();
        Connection connection = conexaoDB.getCon();

        Consultas consulta = new Consultas();
        consulta.listarClientes(connection);

        Cliente clienteRita = new Cliente(100, "Rita", 27,
                "Dona de casa", "Pelotas", "Rio Grande do Sul");
        consulta.inserirCliente(connection, clienteRita);

        Cliente clientePedro = new Cliente(0, "Pedro", 53,
                "Pedreiro", "Salvador", "Bahia");
        consulta.inserirCliente(connection, clientePedro);

        consulta.apagarCliente(connection, "clientes", 100);

        consulta.listarClientes(connection);

        conexaoDB.fecharConexao();
    }
}