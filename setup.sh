mkdir -p ~/tmp
cd ~/tmp

#install jdk 8.12
echo 'fetching jdk-8u112-linux-x64.rpm...'
wget -q --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u112-b15/jdk-8u112-linux-x64.rpm
echo 'jdk-8u112-linux-x64.rpm success...'
sudo yum -y localinstall jdk-8u112-linux-x64.rpm
rm jdk-8u112-linux-x64.rpm

#install maven
echo 'fetching maven...'
sudo wget -q http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
echo 'fetch success...'
sudo yum -y install apache-maven

#set default java
sudo ln -sf /usr/java/jdk1.8.0_112/bin/java /usr/bin/java
sudo sh -c 'echo "export JAVA_HOME=/usr/java/jdk1.8.0_112/" > /etc/profile'