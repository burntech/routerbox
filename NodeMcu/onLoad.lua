print(" Hello.  I am the ESP8266 board and I am ready.")
WIFI_SSID = "YOUR_SSID"
WIFI_PASS = "YOUR WIFI PASSWORD"
ip = wifi.sta.getip()

wifi.setmode(wifi.STATION)
wifi.sta.config(WIFI_SSID, WIFI_PASS)
wifi.sta.connect()
ip = wifi.sta.getip()

print(ip)
print(wifi.sta.status())
 
