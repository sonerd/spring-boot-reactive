package com.spring.reactive.mongo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class MongoConfig {

	@Value("${mongo.uri}")
	String mongoUri;

	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create(mongoUri);
	}

	@Override
	protected String getDatabaseName() {
		return "blog";
	}
}
