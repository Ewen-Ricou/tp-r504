import java.io.*;
import java.net.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import javax.json.*;

public class Client2
{
	public static void main(String[] args) 
	{
		try 
		{
			CloseableHttpClient client = HttpClients.createDefault();
			String url = "http://omdbapi.com/?apikey=751ea6aa&t=" + args[0];
			HttpGet request = new HttpGet(url);
			System.out.println("Executing request " + request.getRequestLine());
			CloseableHttpResponse resp = client.execute(request);
//			System.out.println("Response Line: " + resp.getStatusLine());
//			System.out.println("Response Code: " + resp.getStatusLine().getStatusCode());
			InputStreamReader isr = new InputStreamReader( resp.getEntity().getContent() );
			JsonReader reader = Json.createReader(isr);
			JsonObject jsonObject = reader.readObject();
			System.out.println("Durée = " + jsonObject.getString("Runtime"));
			reader.close();
			isr.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}