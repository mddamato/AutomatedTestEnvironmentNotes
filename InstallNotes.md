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


sudo
easy_install Jinja2



yum install python-httplib2
yum install sshpass









service jenkins start
chkconfig jenkins on

export AWS_ACCESS_KEY_ID='AKIAIXNQHYQT4SLG4DIA'
export AWS_SECRET_ACCESS_KEY='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'


copy 3 files into etc/ansible
from that directory run
ansible-playbook -i ec2.py newPlay.yml



???
wget http://dl.fedoraproject.org/pub/epel/7/x86_64/e/epel-release-7-5.noarch.rpm
sudo rpm -ivh epel-release-7-5.noarch.rpm
sudo yum install ansible -y
???
