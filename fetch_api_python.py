import requests

url = 'https://duonghuuphuc.com/api/cs504070/sendEmail.php'
req_body = {
	"apikey" : "z2UyrD2hH68dRTus",
	"email" : "kietnguyen7398@gmail.com",
	"name" : "Nguyễn Tuấn Kiệt",
	"stu_id" : "51603170",
	"emailType" : "1"
}

r = requests.post(url, json=req_body)

print(r.json())