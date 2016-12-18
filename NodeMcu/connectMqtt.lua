myMsg = "helloFromESP8266"
myTopic = "mark/button"
myMQTT = mqtt.Client('esp1', 12000)
myMQTT:connect("192.168.1.20", 1883, 0, function(conn) 
    print("connected")
    dofile("subscribeMqtt.lua")
    dofile("doLights.lua")
end) 
