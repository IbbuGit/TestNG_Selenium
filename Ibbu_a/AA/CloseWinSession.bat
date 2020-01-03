for /f "tokens=4 delims= " %%G in ('tasklist /FI "IMAGENAME eq tasklist.exe" /NH') do SET RDP_SESSION=%%G
echo Current RDP Session ID: %RDP_SESSION%
%windir%\system32\tscon.exe %RDP_SESSION% /dest:console /password:Advance1