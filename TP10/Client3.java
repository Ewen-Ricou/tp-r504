import java.io.*;
import java.net.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import javax.json.*;
import java.util.Scanner;

public class Client3
{
	public static void main(String[] args) 
	{
		try 
		{
			while (true)
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("Veuillez saisir le titre d'un film : ");
				String str = sc.nextLine();
				str = str.replaceAll("\\s+","+");
				System.out.println("Vous avez saisi : " + str);
				CloseableHttpClient client = HttpClients.createDefault();
				String url = "http://omdbapi.com/?apikey=751ea6aa&t=" + str;
				HttpGet request = new HttpGet(url);
				System.out.println("Executing request " + request.getRequestLine());
				CloseableHttpResponse resp = client.execute(request);
//				System.out.println("Response Line: " + resp.getStatusLine());
//				System.out.println("Response Code: " + resp.getStatusLine().getStatusCode());
				InputStreamReader isr = new InputStreamReader( resp.getEntity().getContent() );
				JsonReader reader = Json.createReader(isr);
				JsonObject jsonObject = reader.readObject();
				System.out.println("Titre = " + jsonObject.getString("Title"));
				System.out.println("Genre = " + jsonObject.getString("Genre"));
				System.out.println("Durée = " + jsonObject.getString("Runtime"));
				System.out.println("Synopsis = " + jsonObject.getString("Plot"));
				reader.close();
				isr.close();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}