**installing ansible and jenkins**

sudo su
yum -y install java wget
wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
yum -y install jenkins
wget http://dl.fedoraproject.org/pub/epel/7/x86_64/e/epel-release-7-5.noarch.rpm
sudo rpm -ivh epel-release-7-5.noarch.rpm
yum -y install python-pip
pip install --upgrade pip
pip install boto3
yum -y install python-paramiko git
pip install ansible --upgrade

mkdir /root/etc/ansible
cd /root/etc/ansible

git clone https://github.com/mongoos2006/JenkinsAnsibleNotes.git


**To start jenkins**

service jenkins start
chkconfig jenkins on

export AWS_ACCESS_KEY_ID='{your access key}'
export AWS_SECRET_ACCESS_KEY='{your secret key}'

ansible-playbook -i ec2.py newPlay.yml
