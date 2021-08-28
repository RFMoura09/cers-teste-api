# CersTesteApi

## All endpoints:

to retreive all messages:
`GET /messages`<br/>
to retreive all unchecked messages:
`GET /messages/unchecked`<br/>
get messages by id:
`GET /messages/id/1`<br/>
get messages count:
`GET /messages/count`<br/>
check a message:
`GET /messages/check/1`<br/>
uncheck a message:
`GET /messages/uncheck/1`<br/>
add a message:
`POST /messages {title, description}`<br/>
update a message:
`PUT /messages/1 {title, description, status(CHECKED, NOT_CHECKED)}`<br/>
delete a message:
`DELETE /messages/1`

## OBS:

the command to create a docker mysql instance, if you want:

`sudo docker run --name mysql-rafael -p {port}:3306 -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=teste_rafael --rm -d mysql:latest`
