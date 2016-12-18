<?php

require("phpMQTT.php");
	
$mqtt = new phpMQTT("192.168.1.20", 1883, "phpMQTTsub");
echo '<br/>Connected.';
if(!$mqtt->connect()){
	exit(1);
}

$topics['mark/button'] = array("qos"=>0, "function"=>"procmsg");
$mqtt->subscribe($topics,0);
echo '<br/>Subscribed.';

while($mqtt->proc()){
		
}

$mqtt->close();

function procmsg($topic,$msg){
	echo '<br/>Publishing<br/>';
	echo $msg;
	echo '<br/>To<br/>';
	echo $topic;
}
	
?>
