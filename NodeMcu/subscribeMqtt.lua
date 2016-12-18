myMQTT:subscribe("mark/button", 0, function(conn) print("button subscribe success") end)
myMQTT:subscribe("mark/lights", 0, function(conn) print("lights subscribe success") end)
myMQTT:subscribe("wiimote/buttonPress", 0, function(conn) print("wiimote button subscribe success") end)
myMQTT:subscribe("wiimote/motion", 0, function(conn) print("wiimote motion subscribe success") end)

myMQTT:on("message", function(client, topic, data) 
  print(topic) 
  print(data)
  if(topic == "wiimote/buttonPress")then
    tmr.stop(1)
    if(data == "a")then
        buffer = ws2812.newBuffer(30, 3)
        buffer:fill(255, 0, 0)
        ws2812.write(buffer)
    end
    if(data == "b")then
        buffer = ws2812.newBuffer(30, 3)
        buffer:fill(0, 255, 0)
        ws2812.write(buffer)
    end
    if(data == "1")then
        buffer = ws2812.newBuffer(30, 3)
        buffer:fill(0, 0, 255)
        ws2812.write(buffer)
    end
    if(data == "2")then
        buffer = ws2812.newBuffer(30, 3)
        buffer:fill(255, 0, 255)
        ws2812.write(buffer)
    end
    if(data == "+")then
         dofile("doLights.lua")
    end
    
  end
  if(topic == "wiimote/motion")then
    print(data)
    t = cjson.decode(data)
    for k,v in pairs(t) do print(k,v) end
    red = t["red"]
    green = t["green"]
    blue = t["blue"]
    buffer = ws2812.newBuffer(30, 3)
    buffer:fill(green, red, blue)
    ws2812.write(buffer)
  end
  if(topic == "mark/lights")then
    t = cjson.decode(data)
    for k,v in pairs(t) do print(k,v) end
    red = t["red"]
    green = t["green"]
    blue = t["blue"]
  end
  if(data == "10") then
    print(string.format("Turn 10 on please."))
    gpio.mode(12, gpio.OUTPUT)
    gpio.write(12, 0) 
  end 
  if(data == "!10") then
    print(string.format("Turn 10 off please.")) 
    gpio.mode(12, gpio.OUTPUT)
    gpio.write(12, 1)   
  end
  if(data == "9") then
    print(string.format("Turn 9 on please."))
    gpio.mode(9, gpio.OUTPUT)
    gpio.write(9, 0) 
  end 
  if(data == "!9") then
    print(string.format("Turn 9 off please.")) 
    gpio.mode(9, gpio.OUTPUT)
    gpio.write(9, 1)   
  end
  if(data == "8") then
    print(string.format("Turn 8 on please."))
    gpio.mode(8, gpio.OUTPUT)
    gpio.write(8, 0) 
  end 
  if(data == "!8") then
    print(string.format("Turn 8 off please.")) 
    gpio.mode(8, gpio.OUTPUT)
    gpio.write(8, 1)   
  end
  if(data == "7") then
    print(string.format("Turn 7 on please."))
    gpio.mode(7, gpio.OUTPUT)
    gpio.write(7, 0) 
  end 
  if(data == "!7") then
    print(string.format("Turn 7 off please.")) 
    gpio.mode(7, gpio.OUTPUT)
    gpio.write(7, 1)   
  end
  if(data == "6") then
    print(string.format("Turn 6 on please."))
    gpio.mode(6, gpio.OUTPUT)
    gpio.write(6, 0) 
  end 
  if(data == "!6") then
    print(string.format("Turn 6 off please.")) 
    gpio.mode(6, gpio.OUTPUT)
    gpio.write(6, 1)   
  end
  if(data == "5") then
    print(string.format("Turn 5 on please."))
    gpio.mode(5, gpio.OUTPUT)
    gpio.write(5, 0) 
  end 
  if(data == "!5") then
    print(string.format("Turn 5 off please.")) 
    gpio.mode(5, gpio.OUTPUT)
    gpio.write(5, 1)   
  end
  if(data == "4") then
    print(string.format("Turn light4 on please."))
    gpio.mode(4, gpio.OUTPUT)
    gpio.write(4, 0) 
  end 
  if(data == "!4") then
    print(string.format("Turn light4 off please.")) 
    gpio.mode(4, gpio.OUTPUT)
    gpio.write(4, 1)   
  end
  if(data == "3") then
    print(string.format("Turn light3 on please."))
    gpio.mode(3, gpio.OUTPUT)
    gpio.write(3, 0)
  end 
  if(data == "!3") then
    print(string.format("Turn light3 off please."))
    gpio.mode(3, gpio.OUTPUT)
    gpio.write(3, 1)
  end

  if(data == "2") then
    print(string.format("Turn 2 on please."))
    gpio.mode(2, gpio.OUTPUT)
    gpio.write(2, 0)
  end 
  if(data == "!2") then
    print(string.format("Turn 2 off please."))
    gpio.mode(2, gpio.OUTPUT)
    gpio.write(2, 1)
  end
  
  if(data == "1") then
    print(string.format("Turn 1 on please."))
    gpio.mode(1, gpio.OUTPUT)
    gpio.write(1, 0)
  end 
  if(data == "!1") then
    print(string.format("Turn 1 off please."))
    gpio.mode(1, gpio.OUTPUT)
    gpio.write(1, 1)
  end
end)
myMQTT:on("connect", function(client) print ("connected") end)
myMQTT:on("offline", function(client) print ("offline") end)
