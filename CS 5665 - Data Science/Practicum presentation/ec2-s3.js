var aws = require('aws-sdk');
aws.config.update({
  accessKeyId: '',
  secretAccessKey: '',
  region:'us-west-2b' 
});
var s3Bucket = new aws.S3({params: {Bucket: 'cs5665-dspracticum-awsdemo-33'}});
//var file = require('fs').readFile('https://s3-us-west-2.amazonaws.com/cs5665-dspracticum-awsdemo-33/SampleData.txt', 'utf8', function (err,data) {
//  if (err) {
//    return console.log(err);
//  }
//  console.log(data);
//});
//var fileContent = s3Bucket.getObject().createReadStream().pipe(file);
//console.log(fileContent);
var request = require('request');
request.get('https://s3-us-west-2.amazonaws.com/cs5665-dspracticum-awsdemo-33/SampleData.txt', function (error, response, data) {
    if (!error && response.statusCode == 200) {
	console.log(data);
    }
});
