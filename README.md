
# vagrant.rest_service.referral_counter

Creates a CentOS 7.2 server w/
  * java 1.8
  * maven 3.3


How to use:
* make sure you have vagrant installed
* open a terminal and
	* cd into the directory you cloned this repo
	* > vagrant up
	* > vagrant ssh
		* this will build the project and start the services


You can acess the summary page at
* http://192.168.110.10/index.html

The endpoints are
* http://192.168.110.10/counter/get/
	* params
		* action
			* list - this will give a full list of all data, filtered if provided
			* count - this will give a summary count of all hits, filtered if provided
			* topthree - this will provide a summary count, by url, of the top three donmains, by count
		* url - filter by url
		* clientid - filter by clientid

* http://192.168.110.10/counter/set/
	* params
		* url - url to record, any non valid url's will be rejected
		* clientid - clientid, optional to support multiple accounts


