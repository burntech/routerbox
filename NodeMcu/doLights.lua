print("do lights")
ws2812.init()
buffer = ws2812.newBuffer(30, 3)
buffer:fill(64, 64, 64)

--GRB
buffer:set(1, 0,51,51) --v
buffer:set(2, 0, 51, 153) --i
buffer:set(3, 0,0,255) --b
buffer:set(4, 255,0,0) --g
buffer:set(5, 255,255,0) --y
buffer:set(6, 51,204,0) --o
buffer:set(7, 0,255,0) --r


ws2812.write(buffer)

tmr.alarm(1,30,1,function()
   buffer:shift(1, ws2812.SHIFT_CIRCULAR)
   ws2812.write(buffer)
end)  

function nextRound(roundCounter)
    if(roundCounter == 1) then
        buffer = ws2812.newBuffer(30, 3)
        buffer:fill(0,255,0)
        
        --GRB
        buffer:set(1, 0,51,51) --v
        buffer:set(2, 0, 51, 153) --i
        buffer:set(3, 0,0,255) --b
        buffer:set(4, 255,0,0) --g
        buffer:set(5, 255,255,0) --y
        buffer:set(6, 51,204,0) --o
        buffer:set(7, 0,255,0) --r
        
        
        ws2812.write(buffer)
    end
    if(roundCounter == 2) then

    end
    if(roundCounter == 3) then

    end
    if(roundCounter == 4) then
    
    end
    if(roundCounter == 5) then

    end
    if(roundCounter == 6) then

    end
    if(roundCounter == 7) then

    end
end
