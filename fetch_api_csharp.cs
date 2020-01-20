using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Net;
using Newtonsoft.Json;
 
class Info {
	  
	public string apikey { get; set; }
	public string email { get; set; } 
	public string name { get; set; } 
	public string stu_id { get; set; }
	public string emailType { get; set; }
	  
 }

public class MainClass {
  
	
  public static void Main (string[] args) {
    //Create a request object
    var httpWebRequest = (HttpWebRequest)WebRequest.Create("https://duonghuuphuc.com/api/cs504070/sendEmail.php");

    httpWebRequest.ContentType = "application/json";
    httpWebRequest.Method = "POST";
	
    //Set body for request
	Info info = new Info();
    info.apikey = "z2UyrD2hH68dRTus";
    info.email = "kietnguyen7398@gmail.com";
    info.name = "Nguyễn Tuấn Kiệt";
    info.stu_id = "51603170";
    info.emailType = "1";  
	  
    using(var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
    {
        string json = JsonConvert.SerializeObject(info); 
        streamWriter.Write(json);
    }

	var httpResponse = (HttpWebResponse)httpWebRequest.GetResponse();
	using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
	{     var result = streamReader.ReadToEnd();
	 	Console.Write(result);
	}

  }
}