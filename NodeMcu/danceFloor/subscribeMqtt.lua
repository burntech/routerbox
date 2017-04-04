myMQTT:subscribe("wiimote/motion", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."lights", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."ten", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."thirtyToOne", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."turboRainbow", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."whiteTrain", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."nyanCat", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."tenRotate", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."slideAway", 0, function(conn) print("subscribe success") end)
myMQTT:subscribe(thingNumber.."bullet", 0, function(conn) print("subscribe success") end)

ws2812.init()
mytimer = tmr.create()
buffer = ws2812.newBuffer(300, 3)
myMQTT:on("message", function(client, topic, data) 
    if not (topic == thingNumber.."bullet")then 
        mytimer:unregister()
    end
  if(topic == "wiimote/motion")then
    print(data)
    lightValues = cjson.decode(data)
    buffer = ws2812.newBuffer(300, 3)
    red = lightValues["red"]
    green = lightValues["green"]
    blue = lightValues["blue"]
    buffer:fill(green, red, blue)
    print("------------")
    ws2812.write(buffer)
  end
  if(topic == thingNumber.."lights")then
    print(data)
    lightValues = cjson.decode(data)
    buffer = ws2812.newBuffer(300, 3)
    red = lightValues["red"]
    green = lightValues["green"]
    blue = lightValues["blue"]
    buffer:fill(green, red, blue)
    print("------------")
    ws2812.write(buffer)
  end
  if(topic == thingNumber.."ten")then
    print(data)
    lightValues = cjson.decode(data)

    num = lightValues["number"]
    red = lightValues["red"]
    green = lightValues["green"]
    blue = lightValues["blue"]
        
    subbuffer = ws2812.newBuffer(30, 3)
    
    subbuffer:fill(green, red, blue)
    
    pos = ((num-1)*30)+1
    buffer:replace(subbuffer, pos)

    ws2812.write(buffer)
  end
  if(topic == thingNumber.."bullet")then
    print(data)
    lightValues = cjson.decode(data)

    red = lightValues["red"]
    green = lightValues["green"]
    blue = lightValues["blue"]
        
    buffer:set(1, green,red,blue)
    buffer:set(2, green,red,blue)
    buffer:set(3, green,red,blue)
  end
  if(topic == thingNumber.."thirtyToOne")then
    print(data)
    subbuffer = ws2812.newBuffer(30, 3)

    msg = cjson.decode(data)
    num = msg["number"]
    lightValues = msg["lightValues"]
    
    for lights = 0, 29 do 
        thisLight = lights*3
        subbuffer:set(lights+1, lightValues[thisLight+1],lightValues[thisLight+2],lightValues[thisLight+3])
    end
    
    pos = ((num-1)*30)+1
    buffer:replace(subbuffer, pos)
    ws2812.write(buffer)

  end
  if(topic == thingNumber.."turboRainbow")then
    dofile("TurboRainbow.lua")
  end
  if(topic == thingNumber.."whiteTrain")then
    dofile("whiteTrain.lua")
  end
  if(topic == thingNumber.."nyanCat")then
    dofile("doLights.lua")
  end
  if(topic == thingNumber.."tenRotate")then
    dofile("tenRotate.lua")
  end
  if(topic == thingNumber.."slideAway")then
    dofile("slideAway.lua")
  end  
  if(topic == thingNumber.."turnOffLights")then
    dofile("turnOffLights.lua")
  end  
end)
myMQTT:on("connect", function(client) print ("connected") end)
myMQTT:on("offline", function(client) print ("offline") end)
