--dofile("connectMqtt.lua")
print("online")
flag = false
gpio.mode(1, gpio.OUTPUT)
gpio.write(1, gpio.LOW)


mytimer = tmr.create()
mytimer:register(1000, tmr.ALARM_AUTO, function()
    print("loop")
    flag = not flag
    if flag then
        
    end
    if not flag then
        
    end
	--replace url with your own that returns either true or false.
    http.get("http://routerbox.xyz/relay.txt", nil, function(code, data)
        if (code < 0) then
          print("HTTP request failed")
        else
          print(data)
          if(data == "true")then
                gpio.write(2, gpio.LOW)
          end
          if(data == "false")then
                gpio.write(2, gpio.HIGH)
          end
        end
    end)
    
end) 
mytimer:start()
