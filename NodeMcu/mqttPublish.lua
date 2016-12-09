local MQTT = require("mqtt_library")
local mqtt_client = MQTT.client.create("YOUR_BROKER_IP", 1883)

mqtt_client:connect("esp")

mqtt_client:publish("topic/name", "hello world")

mqtt_client:destroy()