cd /vagrant/workspace/service.rest/referral_counter
mvn clean
mvn compile
mvn package

sudo kill $(pgrep -a java | sed -rn 's/^([^ ]*).*/\1/p') 2>/dev/null 
nohup sudo java -jar /vagrant/workspace/service.rest/referral_counter/target/referral_counter-*.jar > /vagrant/workspace/service.rest/referral_counter/logs/log.txt 2>&1 &
sudo service mongod start

echo for server status
echo "tail -f /vagrant/workspace/service.rest/referral_counter/logs/log.txt"

