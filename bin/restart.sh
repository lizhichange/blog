
#!/bin/sh

./update.sh
 ./stop.sh
  ./start.sh debug
   tail -f stdout.log
