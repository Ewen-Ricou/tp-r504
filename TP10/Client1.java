import java.io.*;
import java.net.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;


public class Client1
{
	public static void main(String[] args) 
	{
		try 
		{
			CloseableHttpClient client = HttpClients.createDefault();
			String url = "http://omdbapi.com/?apikey=751ea6aa&t=" + args[0];
			HttpGet request = new HttpGet(url);
//			System.out.println(request);
			System.out.println("Executing request " + request.getRequestLine());
			CloseableHttpResponse resp = client.execute(request);
//			System.out.println("Response Line: " + resp.getStatusLine());
//			System.out.println("Response Code: " + resp.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader( new InputStreamReader( resp.getEntity().getContent() ));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null)
			{
				result.append(line);
				result.append("\n");
			}
			String page = result.toString();
			System.out.println(page);
	
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}