# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  
	config.vm.box = "bento/centos-7.2"

	config.vm.provider "virtualbox" do |v|
  		v.memory = 2048
  		v.cpus = 1
	end
	config.vm.network "private_network", ip: "192.168.110.10"
	config.vm.provision "shell", path: "setup.sh"

end
