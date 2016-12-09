flag = 0
uart.on("data", "\n",
  function(data)
    print(string.format("+CSYSID:CHIP:%X;FLASH:%X;KEY:00000000;", node.chipid(), node.flashid()))
    print(string.format("OK"))
  end, 1)
tmr.alarm(0,1000,1,function()
  if(flag == 0) then
    flag = 1
  else
    flag = 0
    print(string.format("Please run file.remove(\"user.lua\") before first use."))
  end
  gpio.mode(4, gpio.OUTPUT)
  gpio.write(4, flag)
end)
