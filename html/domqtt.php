<?php

require("phpMQTT.php");
$mqtt = new phpMQTT("192.168.1.20", 1883, "phpMQTT"); 

if ($mqtt->connect()) {
	$topic = $_GET['topic'];
	$message = $_GET['message']; 
	echo '<br/>Publishing<br/>';
	echo $message;
	echo '<br/>To<br/>';
	echo $topic;
	
	$mqtt->publish($topic,$message,0);
	$mqtt->close();
}else{
	echo '<br/>MQTT connection failed';
}
echo '<br/>done';

?>
