--1 = trig
--4 = echo
signalTrigMS = 0;
signalEchoMS = 0;
diff = 0;

gpio.mode(1, gpio.OUTPUT)
gpio.mode(5, gpio.INT, gpio.PULLUP)

gpio.trig(5, "both", function(level)
    print("5trig");
    if(level == 0) then
        print("echo");
        signalEchoMS = tmr.now()
        diff = signalEchoMS - signalTrigMS
        print("%X", diff)
        gpio.write(1, gpio.HIGH)
    end
end)

tmr.alarm(0,1000,1,function()
  print("trig");
  signalSentMS = tmr.now()
  gpio.write(1, gpio.LOW)
  
end)
