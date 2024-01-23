import java.io.*;
import java.net.*;

public class ServeurTCP3
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket socketserver = new ServerSocket(2016);
			System.out.println("Serveur en attente");
			while(true)
			{
				Socket socket = socketserver.accept();
				System.out.println("Connection d’un client");
				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				System.out.println("Message reçu : " + dIn.readUTF());
				socket.close();
   			}
//           socketserver.close();
        }
		catch (IOException e)
		{
            e.printStackTrace();
        }
    }
}