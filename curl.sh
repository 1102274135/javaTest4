#!/bin/bash
message=$(curl -X POST http://localhost:9001/MARION?lastName=OCAMPO)
echo $message

message=$(curl -X GET http://localhost:9001/?page=2\&pageSize=10)
echo $message

message=$(curl -X PUT http://localhost:9001/customer?firstName=LSDA\&lastName=KJKS\&email=3284232@qq.com\&address1=28\&address2=MySQL\&address3=Boulevard)
cid=$message
echo "添加"
echo "Costumer :$cid"

message=$(curl -X POST http://localhost:9001/customer?id=$cid\&firstName=LSDA\&lastName=KJKS\&email=3284232@qq.com\&addressId=1)

echo "修改"
echo $message
message=$(curl -X DELETE http://localhost:9001/$cid)

echo "删除"
echo "Costumer :$cid"
