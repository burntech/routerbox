ip = wifi.sta.getip()
tmr.delay(1000000) 
print(ip)
print(wifi.sta.status())
