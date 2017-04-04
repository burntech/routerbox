ws2812.init()
buffer = ws2812.newBuffer(300, 3)
buffer:fill(50, 50, 50)
for lights = 1, 300 do
   buffer:set(lights, ((lights%25)*10), ((lights%128)*2), lights) --v
end
ws2812.write(buffer)
mytimer = tmr.create()
mytimer:register(80, tmr.ALARM_AUTO, function()
    print("whiteTrainLoop")
   buffer:shift(1, ws2812.SHIFT_CIRCULAR)
   ws2812.write(buffer)
end) 
mytimer:start() 
