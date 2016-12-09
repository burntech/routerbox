--init.lua, something like this
print("Will run user.lc/user.lua in 1000ms")
tmr.alarm(0,1000,1,function()
  tmr.stop(0)
  local s,err
  if file.open("user.lc") then
    file.close()
    s,err = pcall(function() dofile("user.lc") end)
  else
    s,err = pcall(function() dofile("user.lua") end)
  end
  if not s then print(err) end
end)
