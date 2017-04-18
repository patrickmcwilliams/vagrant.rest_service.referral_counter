package com.demo.referral_counter.rest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.demo.referral_counter.db.Referrer;
import com.demo.referral_counter.db.ReferrerRepository;

@Component("counterService")
public class CounterService {
	
	@Autowired
	private ReferrerRepository db;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private String url;
	private String clientId;
	private String status = "success";
	
	
	public void recordURL(String url, String clientId){
		this.clientId = clientId;
		this.url = url;
		try{
			Referrer referrer = new Referrer(url, clientId);
			db.save(referrer);
		}
		catch(Exception e){
			this.status = "fail";
		}
	}
	


	private List<Referrer> recordList(Map<String, String> data) {
		List<Referrer> list = new ArrayList<>();
		String clientId = data.get("clientId");
		String url = data.get("url");
		
		String queryType = data.get("queryType");
		if ( queryType != null && queryType.equals("topThree") ){
			Aggregation agg = newAggregation(
					group("url").count().as("total"),
					project("total").and("url").previousOperation(),
					sort(Sort.Direction.DESC, "total"),
					limit(3)
				);
			AggregationResults<Referrer> groupResults = mongoTemplate.aggregate(agg, Referrer.class, Referrer.class);
			list = groupResults.getMappedResults();
			
		}
		else if ( clientId.equals("none") && url.equals("none") ){
			list = db.findAll();
		}
		else if( !clientId.equals("none") && url.equals("none") ){
			list = db.findByClientId(clientId);
		}
		else if( clientId.equals("none") && !url.equals("none") ){
			list = db.findByUrl(url);
		}
		else if( !clientId.equals("none") && !url.equals("none") ){
			list = db.findByUrlAndClientId(url, clientId);
		}
		
		return list;
	}
	
	public List<Referrer> listRecords(Map<String, String> data){
		List<Referrer> list = recordList(data);
		return list;
	}
	
	public List<Integer> countRecords(Map<String, String> data){
		List<Referrer> list = recordList(data);
		int count = list.size();
		return ( new ArrayList<>(Arrays.asList(count)) );
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public String getClientId(){
		return this.clientId;
	}
	
	public String getStatus(){
		return this.status;
	}
}
