import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		SocketClient client = new SocketClient();
		client.startConnection("192.168.20.41", 6666);

		Scanner scanner = new Scanner(System.in);

		System.out.println("--------- SOCKET POLI --------");
		System.out.println("1. Registrar\n2. Consultar\n- Escriba la opcion que desea realizar: ");
		String opcionRealizar = scanner.nextLine();

		if (opcionRealizar.equals("1")) {
			System.out.println("Escriba su numero de cuenta: ");
			String numeroCuenta = scanner.nextLine();
			System.out.println("Escriba el valor que tiene en la cuenta: ");
			String valorCuenta = scanner.nextLine();

			String mensaje = "{REGISTRAR}"+numeroCuenta + "," + valorCuenta;
			String response = client.sendMessage(mensaje);
			System.out.println(response);
		}
		
		if (opcionRealizar.equals("2")) {
			System.out.println("Escriba el numero de cuenta a consultar: ");
			String numeroCuenta = scanner.nextLine();

			String mensaje = "{CONSULTAR}"+numeroCuenta;
			String response = client.sendMessage(mensaje);
			System.out.println(response);
		}

		client.stopConnection();
	}

}
