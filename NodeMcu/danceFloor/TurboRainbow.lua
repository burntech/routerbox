ws2812.init()
buffer = ws2812.newBuffer(300, 3)
--buffer:fill(64, 64, 64)
for lights = 1, 300 do 
    --GRB
    if(lights % 10 == 0)then
        buffer:set(lights, 0,51,51) --v
    end
    if(lights % 10 == 1)then
        buffer:set(lights, 0, 51, 153) --i
    end
    if(lights % 10 == 2)then
        buffer:set(lights, 0,0,255) --b
    end
    if(lights % 10 == 3)then
        buffer:set(lights, 255,0,0) --g
    end
    if(lights % 10 == 4)then
        buffer:set(lights, 255,255,0) --y
    end
    if(lights % 10 == 5)then
        buffer:set(lights, 51,204,0) --o
    end
    if(lights % 10 == 6)then
        buffer:set(lights, 0,255,0) --r
    end
    if(lights % 10 == 7)then
        buffer:set(lights, 0,0,0) --r
    end
    if(lights % 10 == 8)then
        buffer:set(lights, 0,0,0) --r
    end
    if(lights % 10 == 9)then
        buffer:set(lights, 0,0,0) --r
    end
end
ws2812.write(buffer)
mytimer = tmr.create()
mytimer:register(80, tmr.ALARM_AUTO, function()
    print("turboRainbowLoop")
   buffer:shift(1, ws2812.SHIFT_CIRCULAR)
   ws2812.write(buffer)
end) 
mytimer:start()
