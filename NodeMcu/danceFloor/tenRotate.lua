ws2812.init()
buffer = ws2812.newBuffer(300, 3)
buffer:fill(64, 64, 64)

for lights = 1, 30 do 
    buffer:set(lights, 0,51,51) --v
end

for lights = 31, 60 do 
    buffer:set(lights, 0, 51, 153) --i
end

for lights = 61, 90 do 
    buffer:set(lights, 0,0,255) --b
end
for lights = 91, 120 do 
    buffer:set(lights, 255,0,0) --g
end
for lights = 121, 150 do 
    buffer:set(lights, 255,255,0) --y
end
for lights = 151, 180 do 
    buffer:set(lights, 51,204,0) --o
end
for lights = 181, 210 do 
    buffer:set(lights, 0,255,0) --r
end
for lights = 211, 240 do 
    buffer:set(lights, 255,0,255) --?
end
for lights = 241, 270 do 
    buffer:set(lights, 25,25,25) --r
end
for lights = 271, 300 do 
    buffer:set(lights, 255,255,255) --r
end

ws2812.write(buffer)
mytimer = tmr.create()
mytimer:register(80, tmr.ALARM_AUTO, function()
    print("tenRotateLoop")
   buffer:shift(1, ws2812.SHIFT_CIRCULAR)
   ws2812.write(buffer)
end) 
mytimer:start()

