time1 = 0
time2 = 0
time3 = 0

pulse_width = 0
pulse_width2 = 0

cm = 0
inches = 0
MAX_DIST = 23200

gpio.mode(1, gpio.OUTPUT)
gpio.write(1, gpio.LOW)

gpio.mode(5, gpio.OUTPUT)
gpio.write(5, gpio.LOW)
gpio.mode(5, gpio.INPUT)
print(gpio.read(5))
 

time1 = tmr.now()
gpio.write(1, gpio.HIGH)
tmr.delay(10)
gpio.write(1, gpio.LOW)
print("trig")

while(gpio.read(5) == 0) do
--print("0")
end
time1 = tmr.now()
while(gpio.read(5)==1)do
--print("1")
end
time2 = tmr.now()
pulse_width = time2-time1
print(pulse_width)

if(pulse_width < 3000)then
myMQTT:publish("mark/sonic","go",0,0, function(conn) print("go") end) 
end

if(pulse_width > 3000)then
myMQTT:publish("mark/sonic","stop",0,0, function(conn) print("stop") end) 
end
