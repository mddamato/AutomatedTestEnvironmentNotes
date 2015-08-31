*Do a serenity test*

**INSTALL: Java 8, X virtual framebuffer, gradle 2.4, fonts, xserver-xorg-core, firefox**
sudo add-apt-repository ppa:webupd8team/java -y
sudo add-apt-repository ppa:cwchien/gradle -y
sudo apt-get update
sudo apt-get install -y oracle-java8-installer
sudo apt-get -y install xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic firefox xvfb git gradle-2.6 xserver-xorg-core
export JAVA_HOME=/usr/lib/jvm/java-8-oracle/

**set up virtual display**
Xvfb :99 -screen 0 1024x768x24 -ac 2>&1 >/dev/null &
export DISPLAY=:99

**clone repo and build**
git clone https://github.com/mongoos2006/SerenityJBehaveWiki.git
cd SerenityJBehaveWiki
gradle clean test aggregate --info

**optional installs**
***chrome install -- optional***
wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
sudo sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
sudo apt-get update
sudo apt-get -y install google-chrome-stable
wget http://chromedriver.googlecode.com/files/chromedriver_linux64_23.0.1240.0.zip
sudo apt-get -y install unzip
unzip chromedriver_linux64_23.0.1240.0.zip
sudo cp chromedriver /usr/local/bin

***to host the report from this EC2--optional***
sudo apt-get install -y tomcat7
sudo vi /etc/init.d/tomcat7
add to line that reads JDK_DIRS : "/usr/lib/jvm/java-8-oracle"
sudo mkdir /usr/share/tomcat7/webapps
sudo cp -r ~/SerenityJBehaveWiki/target/site/serenity /usr/share/tomcat7/webapps/
sudo vi /etc/tomcat7/Catalina/localhost/serenity.xml
add to serenity.xml: <Context path="/serenity" docBase="/usr/share/tomcat7/webapps/serenity"/>
sudo service tomcat7 restart
navigate to publicDNS:8080/serenity
