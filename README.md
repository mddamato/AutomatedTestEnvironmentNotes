# Test environment setup - Serenity/JBehave/EC2 #

## Installation of major dependencies ##
**INSTALL: Java 8, X virtual framebuffer, gradle 2.6, fonts, xserver-xorg-core, firefox**
```bash
sudo add-apt-repository ppa:webupd8team/java -y
sudo add-apt-repository ppa:cwchien/gradle -y
sudo apt-get update
sudo apt-get install -y oracle-java8-installer
sudo apt-get -y install xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic firefox xvfb git gradle-2.6 xserver-xorg-core
export JAVA_HOME=/usr/lib/jvm/java-8-oracle/
export GRADLE_OPTS="-Xmx2048m -Xms1024m -XX:+CMSClassUnloadingEnabled -XX:+HeapDumpOnOutOfMemoryError"
```

## Installation of virtual display ##
```bash
Xvfb :99 -screen 0 1024x768x24 -ac 2>&1 >/dev/null &
export DISPLAY=:99
```

## Clone Git repo and test ##
```bash
git clone https://github.com/mongoos2006/SerenityJBehaveWiki.git
cd SerenityJBehaveWiki
gradle clean test aggregate --info
```
All reports should now be located in ~/SerenityJBehaveWiki/target/site/serenity/

## Optional installations ##
### chrome install -- optional ###
```bash
wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
sudo sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
sudo apt-get update
sudo apt-get -y install google-chrome-stable
wget http://chromedriver.googlecode.com/files/chromedriver_linux64_23.0.1240.0.zip
sudo apt-get -y install unzip
unzip chromedriver_linux64_23.0.1240.0.zip
sudo cp chromedriver /usr/local/bin
```

### Install Tomcat to host report file -- optional ###
```bash
sudo apt-get install -y tomcat7
sudo vi /etc/init.d/tomcat7
add to line that reads JDK_DIRS : "/usr/lib/jvm/java-8-oracle"
sudo mkdir /usr/share/tomcat7/webapps
sudo vi /etc/tomcat7/Catalina/localhost/serenity.xml
```
add to serenity.xml:
```xml
<Context path="/serenity" docBase="/usr/share/tomcat7/webapps/serenity"/>
```
**export report**
```bash
sudo cp -r ~/SerenityJBehaveWiki/target/site/serenity /usr/share/tomcat7/webapps/
sudo service tomcat7 restart
navigate to publicDNS:8080/serenity
```



# Ansible/Jenkins Setup - Serenity/JBehave/EC2 #
## installing ansible and jenkins ##
```bash
sudo su
yum -y update
wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
yum -y install jenkins
yum -y install python-pip python-paramiko git openssl
pip install --upgrade boto boto3
rpm -iUvh http://dl.fedoraproject.org/pub/epel/7/x86_64/e/epel-release-7-5.noarch.rpm
yum install ansible -y
cd ~/../../etc/ansible/
git clone https://github.com/mongoos2006/AutomatedTestEnvironmentNotes.git
cd JenkinsAnsibleNotes
export AWS_ACCESS_KEY_ID='{access key}'
export AWS_SECRET_ACCESS_KEY='{secret key}'
openssl des3 -d -in encryptedKey.pem -out KeyPair2.pem
```
Enter password from passwordFile when prompted to decrypt encryptedKey.pem

**To run play**
```bash
ansible-playbook -i ec2.py newPlay.yml
```

**To start jenkins**
```bash
service jenkins start
chkconfig jenkins on
```
