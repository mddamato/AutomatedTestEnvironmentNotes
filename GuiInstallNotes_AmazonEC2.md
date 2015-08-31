**installing GUI on amazon EC2**
sudo apt-get install ubuntu-desktop
sudo apt-get install tightvncserver
vncserver :1
password
n


vi ~/.vnc/xstartup
add to file "
gnome-session --session=ubuntu-2d
"

---

sudo apt-get --install-recommends install ubuntu-desktop


Steps--

1. Connect ssh to ec2 instance.

2. Become the super user after executing the command
sudo -s

3. Type the following commands to install vncserver:

sudo apt-get update
sudo apt-get --install-recommends install ubuntu-desktop
sudo apt-get install -y vnc4server
sudo apt-get install -y gnome-panel

4. Type the command vncserver once.

5. Remember the password you use for accessing the vncserver. Kill vncserver by typing the command vncserver-kill :1

6. Type vi .vnc/xstartup and modify the file
#!/bin/sh
# Uncomment the following two lines for normal desktop:
unset SESSION_MANAGER
# exec /etc/X11/xinit/xinitrc
gnome-session –session=gnome-classic &
gnome-panel&

7. Press ESC, followed by :wq to save and exit the file

8. Type vncserver again to start vncserver.

9. Download and install tightvnc to connect remote desktop from the following link
http://www.tightvnc.com/download.php

10. Now run tightvnc viewer

11. Add the port no 5901 in your ec2 security group

12. Write your public ip in remote host text box and port no. publicIp::port

13. Your desktop in ec2 instance is ready and execute the command vncserver after every restart.



---

sudo add-apt-repository ppa:webupd8team/java -y
sudo apt-get update
sudo apt-get install -y oracle-java8-installer

sudo apt-get -y install xvfb

sudo apt-get install -y gradle

sudo apt-get install -y git

git clone https://github.com/mongoos2006/SerenityJBehaveWiki.git

sudo apt-get -y install xserver-xorg-core

sudo apt-get -y install xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic


wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
sudo sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
sudo apt-get update
sudo apt-get -y install google-chrome-stable

wget http://chromedriver.googlecode.com/files/chromedriver_linux64_23.0.1240.0.zip
sudo apt-get -y install unzip
unzip chromedriver_linux64_23.0.1240.0.zip
sudo cp chromedriver /usr/local/bin

sudo apt-get -y install firefox

remove line 70 from usr/bin/gradle "export java_home"

Xvfb :99 -screen 0 1024x768x24 -ac 2>&1 >/dev/null &

export DISPLAY=:99

sudo apt-get install tomcat7

sudo vi /etc/default/tomcat7
replace line 21:
JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom -Djava.awt.headless=true -Xmx512m -XX:MaxPermSize=256m -XX:+UseConcMarkSweepGC"

vi to /etc/init.d/tomcat7 and add to JDK_DIRS
/usr/lib/jvm/java-8-oracle

sudo mkdir /usr/share/tomcat7/webapps/Reports

gradle clean test aggregate --info

sudo cp -r ~/SerenityJBehaveWiki/target/site/serenity /usr/share/tomcat7/webapps/

sudo vi /etc/tomcat7/Catalina/localhost/serenity.xml
add:
<Context path="/serenity" docBase="/usr/share/tomcat7/webapps/serenity"/>

sudo service tomcat7 restart
