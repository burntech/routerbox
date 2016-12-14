--init.lua, something like this
print("Will run onLoad.lc")
dofile("onLoad.lc")

wifiUp = false

tmr.alarm(0,1000,1,function()
  if(wifi.sta.status() == 5)then
       tmr.stop(0) 
       wifiUp = true
       dofile("connectMqtt.lua")
  end
end)
