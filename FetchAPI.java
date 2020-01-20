import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchAPI {

	private static final String URL = "https://duonghuuphuc.com/api/cs504070/sendEmail.php";

	public static void main(String[] args) {
		try {
			sendPostRequest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendPostRequest() throws IOException {
		URL url = new URL(URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);

		String req_body = "{\r\n" + "	\"apikey\" : \"z2UyrD2hH68dRTus\",\r\n"
				+ "	\"email\" : \"kietnguyen7398@gmail.com\",\r\n" + "	\"name\" : \"Nguyễn Tuấn Kiệt\",\r\n"
				+ "	\"stu_id\" : \"51603170\",\r\n" + "	\"emailType\" : \"1\"\r\n" + "}";

		try (OutputStream os = con.getOutputStream()) {
			byte[] input = req_body.getBytes();
			os.write(input, 0, input.length);
			os.flush();
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}

	}
}
