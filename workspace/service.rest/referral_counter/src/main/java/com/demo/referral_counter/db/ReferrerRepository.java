package com.demo.referral_counter.db;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.referral_counter.db.Referrer;

public interface ReferrerRepository extends MongoRepository<Referrer, String>{

    public List<Referrer> findByUrl(String url);
    public List<Referrer> findByClientId(String clientId);
    public List<Referrer> findByUrlAndClientId(String url, String clientId);
	
}

