myMsg = "helloFromESP8266"
myTopic = "mark/button"
myMQTT = mqtt.Client('esp', 12000)
myMQTT:connect("YOUR_BROKER_IP", 1883, 0, function(conn) print("connected") end)
