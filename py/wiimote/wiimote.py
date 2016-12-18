# This program utilises the cwiid Python library in order to get input over bluetooth from a wiimote.
# The following lines of code demonstrate many of the features realted to wiimotes, such as capturing button presses and rumbling the controller.
# I have managed to map the home button to the accelerometer - simply hold it and values will appear!

# Coded by The Raspberry Pi Guy. Work based on some of Matt Hawkins's!

import cwiid, time
import paho.mqtt.client as mqtt
import paho.mqtt.publish as publish

button_delay = 0.1

mqttc = mqtt.Client()

def on_connect(client, userdata, flags, rc):
    print("Connection returned result: ")

mqttc.on_connect = on_connect

def on_disconnect(client, userdata, rc):
    if rc != 0:
        print("Unexpected disconnection.")

mqttc.on_disconnect = on_disconnect

mqttc.connect("192.168.1.20", port=1883, keepalive=60, bind_address="")
mqttc.loop_start()

print 'Please press buttons 1 + 2 on your Wiimote now ...'
time.sleep(1)

# This code attempts to connect to your Wiimote and if it fails the program quits
try:
  wii=cwiid.Wiimote()
except RuntimeError:
  print "Cannot connect to your Wiimote. Run again and make sure you are holding buttons 1 + 2!"
  quit()

print 'Wiimote connection established!\n'
print 'Go ahead and press some buttons\n'
print 'Press PLUS and MINUS together to disconnect and quit.\n'

time.sleep(3)

wii.rpt_mode = cwiid.RPT_BTN

while True:
  buttons = wii.state['buttons']

  # Detects whether + and - are held down and if they are it quits the program
  if (buttons - cwiid.BTN_PLUS - cwiid.BTN_MINUS == 0):
    print '\nClosing connection ...'
    mqttc.loop_stop(force=False)
    # NOTE: This is how you RUMBLE the Wiimote
    wii.rumble = 1
    time.sleep(1)
    wii.rumble = 0
    exit(wii)

  # The following code detects whether any of the Wiimotes buttons have been pressed and then prints a statement to the screen!
  if (buttons & cwiid.BTN_LEFT):
    print 'Left pressed'
    publish.single("wiimote/buttonPress", "left", hostname="192.168.1.20")
    #mqttc.publish("wiimote/buttonPress", "left")
    time.sleep(button_delay)

  if(buttons & cwiid.BTN_RIGHT):
    print 'Right pressed'
    #mqttc.publish("wiimote/buttonPress", "right")
    publish.single("wiimote/buttonPress", "right", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_UP):
    print 'Up pressed'
    #mqttc.publish("wiimote/buttonPress", "up")
    publish.single("wiimote/buttonPress", "up", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_DOWN):
    print 'Down pressed'
    #mqttc.publish("wiimote/buttonPress", "down")
    publish.single("wiimote/buttonPress", "down", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_1):
    print 'Button 1 pressed'
    #mqttc.publish("wiimote/buttonPress", "one")
    publish.single("wiimote/buttonPress", "one", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_2):
    print 'Button 2 pressed'
    #mqttc.publish("wiimote/buttonPress", "two")
    publish.single("wiimote/buttonPress", "two", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_A):
    print 'Button A pressed'
    #mqttc.publish("wiimote/buttonPress", "a")
    publish.single("wiimote/buttonPress", "a", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_B):
    print 'Button B pressed'
    #mqttc.publish("wiimote/buttonPress", "b")
    publish.single("wiimote/buttonPress", "b", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_HOME):
    wii.rpt_mode = cwiid.RPT_BTN | cwiid.RPT_ACC
    check = 0
    while check == 0:
      #mqttc.publish("wiimote/motion", "wii.state['acc']")
      accList = list(wii.state['acc'])
      redDiff = 125 - accList[0]
      if(redDiff < 0):
        redDiff = redDiff * -1
      if(redDiff < 5):
          redDiff = 0
      greenDiff = 129 - accList[1]
      if(greenDiff < 0):
        greenDiff = greenDiff * -1
      if(greenDiff < 5):
          greenDiff = 0  
      blueDiff = 155 - accList[2]
      if(blueDiff < 0):
        blueDiff = blueDiff * -1
      if(blueDiff < 5):
        blueDiff = 0
      msg = '{"red":'+str(redDiff*2)+', "green":'+str(greenDiff*2)+', "blue":'+str(blueDiff*2)+'}'
      publish.single("wiimote/motion", msg, hostname="192.168.1.20")
      print(wii.state['acc'])
      print(str(type(wii.state['acc'])))
      time.sleep(0.01)
      check = (buttons & cwiid.BTN_HOME)
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_MINUS):
    print 'Minus Button pressed'
    #mqttc.publish("wiimote/buttonPress", "-")
    publish.single("wiimote/buttonPress", "-", hostname="192.168.1.20")
    time.sleep(button_delay)

  if (buttons & cwiid.BTN_PLUS):
    print 'Plus Button pressed'
    #mqttc.publish("wiimote/buttonPress", "+")
    publish.single("wiimote/buttonPress", "+", hostname="192.168.1.20")
    time.sleep(button_delay)
