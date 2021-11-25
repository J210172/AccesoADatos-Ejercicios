import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	private Socket chatSocket;
	private InputStreamReader stream;
	private BufferedReader reader;
	private PrintWriter writer;
	public Cliente(String ip, int port) throws IOException {
		chatSocket = new Socket("127.0.0.1", 5000);
		stream = new InputStreamReader(chatSocket.getInputStream());
		reader = new BufferedReader(stream);
		writer = new PrintWriter(chatSocket.getOutputStream());
	}
	
	public String readMesage() throws IOException {
		return reader.readLine();
	}
	
	public void sendMessage(String message) {
		
	}
}
