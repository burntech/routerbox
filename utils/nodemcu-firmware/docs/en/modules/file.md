# file Module
| Since  | Origin / Contributor  | Maintainer  | Source  |
| :----- | :-------------------- | :---------- | :------ |
| 2014-12-22 | [Zeroday](https://github.com/funshine) | [Zeroday](https://github.com/funshine) | [file.c](../../../app/modules/file.c)|

The file module provides access to the file system and its individual files.

The file system is a flat file system, with no notion of subdirectories/folders.

Besides the SPIFFS file system on internal flash, this module can also access FAT partitions on an external SD card is [FatFS is enabled](../sdcard.md).

```lua
-- open file in flash:
if file.open("init.lua") then
  print(file.read())
  file.close()
end

-- or with full pathspec
file.open("/FLASH/init.lua")

-- open file on SD card
if file.open("/SD0/somefile.txt") then
  print(file.read())
  file.close()
end
```

## file.chdir()

Change current directory (and drive). This will be used when no drive/directory is prepended to filenames.

Current directory defaults to the root of internal SPIFFS (`/FLASH`) after system start.

#### Syntax
`file.chdir(dir)`

#### Parameters
`dir` directory name - `/FLASH`, `/SD0`, `/SD1`, etc.

#### Returns
`true` on success, `false` otherwise

## file.exists()

Determines whether the specified file exists.

#### Syntax
`file.exists(filename)`

#### Parameters
- `filename` file to check

#### Returns
true of the file exists (even if 0 bytes in size), and false if it does not exist

#### Example

```lua
files = file.list()
if files["device.config"] then
    print("Config file exists")
end

if file.exists("device.config") then
    print("Config file exists")
end
```
#### See also
[`file.list()`](#filelist)

## file.format()

Format the file system. Completely erases any existing file system and writes a new one. Depending on the size of the flash chip in the ESP, this may take several seconds.

Not supported for SD cards.

#### Syntax
`file.format()`

#### Parameters
none

#### Returns
`nil`

#### See also
[`file.remove()`](#fileremove)

## file.fscfg ()

Returns the flash address and physical size of the file system area, in bytes.

Not supported for SD cards.

#### Syntax
`file.fscfg()`

#### Parameters
none

#### Returns
- `flash address` (number)
- `size` (number)

#### Example
```lua
print(string.format("0x%x", file.fscfg()))
```

## file.fsinfo()

Return size information for the file system. The unit is Byte for SPIFFS and kByte for FatFS.

#### Syntax
`file.fsinfo()`

#### Parameters
none

#### Returns
- `remaining` (number)
- `used`      (number)
- `total`     (number)

#### Example

```lua
-- get file system info
remaining, used, total=file.fsinfo()
print("\nFile system info:\nTotal : "..total.." (k)Bytes\nUsed : "..used.." (k)Bytes\nRemain: "..remaining.." (k)Bytes\n")
```

## file.list()

Lists all files in the file system.

#### Syntax
`file.list()`

#### Parameters
none

#### Returns
a lua table which contains the {file name: file size} pairs

#### Example
```lua
l = file.list();
for k,v in pairs(l) do
  print("name:"..k..", size:"..v)
end
```

## file.mount()

Mounts a FatFs volume on SD card.

Not supported for internal flash.

#### Syntax
`file.mount(ldrv[, pin])`

#### Parameters
- `ldrv` name of the logical drive, `SD0:`, `SD1:`, etc.
- `pin` 1~12, IO index for SS/CS, defaults to 8 if omitted.

#### Returns
Volume object

#### Example
```lua
vol = file.mount("SD0:")
vol:umount()
```

## file.on()

Registers callback functions.

Trigger events are:
- `rtc` deliver current date & time to the file system. Function is expected to return a table containing the fields `year`, `mon`, `day`, `hour`, `min`, `sec` of current date and time. Not supported for internal flash.

#### Syntax
`file.on(event[, function()])`

#### Parameters
- `event` string
- `function()` callback function. Unregisters the callback if `function()` is omitted.

#### Returns
`nil`

#### Example
```lua
sntp.sync(server_ip,
  function()
    print("sntp time sync ok")
    file.on("rtc",
      function()
        return rtctime.epoch2cal(rtctime.get())
      end)
  end)
```

#### See also
[`rtctime.epoch2cal()`](rtctime.md#rtctimepoch2cal)

## file.open()

Opens a file for access, potentially creating it (for write modes).

When done with the file, it must be closed using `file.close()`.

#### Syntax
`file.open(filename, mode)`

#### Parameters
- `filename` file to be opened, directories are not supported
- `mode`:
    - "r": read mode (the default)
    - "w": write mode
    - "a": append mode
    - "r+": update mode, all previous data is preserved
    - "w+": update mode, all previous data is erased
    - "a+": append update mode, previous data is preserved, writing is only allowed at the end of file

#### Returns
file object if file opened ok. `nil` if file not opened, or not exists (read modes).

#### Example (basic model)
```lua
-- open 'init.lua', print the first line.
if file.open("init.lua", "r") then
  print(file.readline())
  file.close()
end
```
#### Example (object model)
```lua
-- open 'init.lua', print the first line.
fd = file.open("init.lua", "r")
if fd then
  print(fd:readline())
  fd:close(); fd = nil
end
```

#### See also
- [`file.close()`](#fileclose)
- [`file.readline()`](#filereadline)

## file.remove()

Remove a file from the file system. The file must not be currently open.

###Syntax
`file.remove(filename)`

#### Parameters
`filename` file to remove

#### Returns
`nil`

#### Example

```lua
-- remove "foo.lua" from file system.
file.remove("foo.lua")
```
#### See also
[`file.open()`](#fileopen)

## file.rename()

Renames a file. If a file is currently open, it will be closed first.

#### Syntax
`file.rename(oldname, newname)`

#### Parameters
- `oldname` old file name
- `newname` new file name

#### Returns
`true` on success, `false` on error.

#### Example

```lua
-- rename file 'temp.lua' to 'init.lua'.
file.rename("temp.lua","init.lua")
```

# File access functions

The `file` module provides several functions to access the content of a file after it has been opened with [`file.open()`](#fileopen). They can be used as part of a basic model or an object model:

## Basic model
In the basic model there is max one file opened at a time. The file access functions operate on this file per default. If another file is opened, the previous default file needs to be closed beforehand.

```lua
-- open 'init.lua', print the first line.
if file.open("init.lua", "r") then
  print(file.readline())
  file.close()
end
```

## Object model
Files are represented by file objects which are created by `file.open()`. File access functions are available as methods of this object, and multiple file objects can coexist.

```lua
src = file.open("init.lua", "r")
if src then
  dest = file.open("copy.lua", "w")
  if dest then
    local line
    repeat
      line = src:read()
      if line then
        dest:write(line)
      end
    until line == nil
    dest:close(); dest = nil
  end
  src:close(); dest = nil
end
```

!!! Attention

    It is recommended to use only one single model within the application. Concurrent use of both models can yield unpredictable behavior: Closing the default file from basic model will also close the correspoding file object. Closing a file from object model will also close the default file if they are the same file.

!!! Note

    The maximum number of open files on SPIFFS is determined at compile time by `SPIFFS_MAX_OPEN_FILES` in `user_config.h`.

## file.close()
## file.obj:close()

Closes the open file, if any.

#### Syntax
`file.close()`

`fd:close()`

#### Parameters
none

#### Returns
`nil`

#### See also
[`file.open()`](#fileopen)

## file.flush()
## file.obj:flush()

Flushes any pending writes to the file system, ensuring no data is lost on a restart. Closing the open file using [`file.close()` / `fd:close()`](#fileclose) performs an implicit flush as well.

#### Syntax
`file.flush()`

`fd:flush()`

#### Parameters
none

#### Returns
`nil`

#### Example (basic model)
```lua
-- open 'init.lua' in 'a+' mode
if file.open("init.lua", "a+") then
  -- write 'foo bar' to the end of the file
  file.write('foo bar')
  file.flush()
  -- write 'baz' too
  file.write('baz')
  file.close()
end
```

#### See also
[`file.close()` / `file.obj:close()`](#fileclose)

## file.read()
## file.obj:read()

Read content from the open file.

!!! note

    The function temporarily allocates 2 * (number of requested bytes) on the heap for buffering and processing the read data. Default chunk size (`FILE_READ_CHUNK`) is 1024 bytes and is regarded to be safe. Pushing this by 4x or more can cause heap overflows depending on the application. Consider this when selecting a value for parameter `n_or_char`.

#### Syntax
`file.read([n_or_char])`

`fd:read([n_or_char])`

#### Parameters
- `n_or_char`:
	- if nothing passed in, then read up to `FILE_READ_CHUNK` bytes or the entire file (whichever is smaller).
	- if passed a number `n`, then read up to `n` bytes or the entire file (whichever is smaller).
	- if passed a string containing the single character `char`, then read until `char` appears next in the file, `FILE_READ_CHUNK` bytes have been read, or EOF is reached.

#### Returns
File content as a string, or nil when EOF

#### Example (basic model)
```lua
-- print the first line of 'init.lua'
if file.open("init.lua", "r") then
  print(file.read('\n'))
  file.close()
end
```

#### Example (object model)
```lua
-- print the first 5 bytes of 'init.lua'
fd = file.open("init.lua", "r")
if fd then
  print(fd:read(5))
  fd:close(); fd = nil
end
```

#### See also
- [`file.open()`](#fileopen)
- [`file.readline()` / `file.obj:readline()`](#filereadline)

## file.readline()
## file.obj:readline()

Read the next line from the open file. Lines are defined as zero or more bytes ending with a EOL ('\n') byte. If the next line is longer than 1024, this function only returns the first 1024 bytes.

#### Syntax
`file.readline()`

`fd:readline()`

#### Parameters
none

#### Returns
File content in string, line by line, including EOL('\n'). Return `nil` when EOF.

#### Example (basic model)
```lua
-- print the first line of 'init.lua'
if file.open("init.lua", "r") then
  print(file.readline())
  file.close()
end
```

#### See also
- [`file.open()`](#fileopen)
- [`file.close()` / `file.obj:close()`](#fileclose)
- [`file.read()` / `file.obj:read()`](#fileread)


## file.seek()
## file.obj:seek()

Sets and gets the file position, measured from the beginning of the file, to the position given by offset plus a base specified by the string whence.

#### Syntax
`file.seek([whence [, offset]])`

`fd:seek([whence [, offset]])`

#### Parameters
- `whence`
	- "set": base is position 0 (beginning of the file)
	- "cur": base is current position (default value)
	- "end": base is end of file
- `offset` default 0

If no parameters are given, the function simply returns the current file offset.

#### Returns
the resulting file position, or `nil` on error

#### Example (basic model)
```lua
if file.open("init.lua", "r") then
  -- skip the first 5 bytes of the file
  file.seek("set", 5)
  print(file.readline())
  file.close()
end
```
#### See also
[`file.open()`](#fileopen)

## file.write()
## file.obj:write()

Write a string to the open file.

#### Syntax
`file.write(string)`

`fd:write(string)`

#### Parameters
`string` content to be write to file

#### Returns
`true` if the write is ok, `nil` on error

#### Example (basic model)
```lua
-- open 'init.lua' in 'a+' mode
if file.open("init.lua", "a+") then
  -- write 'foo bar' to the end of the file
  file.write('foo bar')
  file.close()
end
```

#### Example (object model)
```lua
-- open 'init.lua' in 'a+' mode
fd = file.open("init.lua", "a+")
if fd then
  -- write 'foo bar' to the end of the file
  fd:write('foo bar')
  fd:close()
end
```

#### See also
- [`file.open()`](#fileopen)
- [`file.writeline()` / `file.obj:writeline()`](#filewriteline)

## file.writeline()
## file.obj:writeline()

Write a string to the open file and append '\n' at the end.

#### Syntax
`file.writeline(string)`

`fd:writeline(string)`

#### Parameters
`string` content to be write to file

#### Returns
`true` if write ok, `nil` on error

#### Example (basic model)
```lua
-- open 'init.lua' in 'a+' mode
if file.open("init.lua", "a+") then
  -- write 'foo bar' to the end of the file
  file.writeline('foo bar')
  file.close()
end
```

#### See also
- [`file.open()`](#fileopen)
- [`file.readline()` / `file.obj:readline()`](#filereadline)
