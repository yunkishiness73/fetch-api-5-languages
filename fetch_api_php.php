<?php
$req = array(
	"apikey" => "z2UyrD2hH68dRTus",
	"email" => "kietnguyen7398@gmail.com",
	"name" => "Nguyễn Tuấn Kiệt",
	"stu_id" => "51603170",
	"emailType" => "1"
);

$req_string = json_encode($req);

//create new curl
$curl = curl_init("https://duonghuuphuc.com/api/cs504070/sendEmail.php");


//config for curl
curl_setopt($curl, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($curl, CURLOPT_POSTFIELDS, $req_string);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_HTTPHEADER, array(
    'Content-Type: application/json'
    )
);


//execute
$result = curl_exec($curl);

echo "<pre>";
var_dump($result);
echo "</pre>";


//close curl
curl_close($curl);

