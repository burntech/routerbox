--init.lua, something like this
print("Will run onLoad.lua")
dofile("onLoad.lua")
--dofile("doLights.lua")

wifiUp = false

tmr.alarm(0,1000,1,function()
  if(wifi.sta.status() == 5)then
        print("Connected")
       tmr.stop(0) 
       wifiUp = true 
       dofile("connectMqtt.lua")
  end
end)
