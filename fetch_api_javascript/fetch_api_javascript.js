const fetch = require('node-fetch');

const url = 'https://duonghuuphuc.com/api/cs504070/sendEmail.php';
const req_body = {
	apikey : "z2UyrD2hH68dRTus",
	email : "kietnguyen7398@gmail.com",
	name : "Nguyễn Tuấn Kiệt",
	stu_id : "51603170",
	emailType : "1"
}

const options = {
	method: 'post',
	body: JSON.stringify(req_body),
	headers: {
		'Content-Type': 'application/json'
	}
}

//fetch api
fetch(url, options)
	.then(res => res.json())
	.then(json => console.log(json))
	.catch(err => {
		console.log('Can not fetch api');
		console.log(err);
	})