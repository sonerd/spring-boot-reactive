package com.spring.reactive.mongo.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class MongoConfig extends AbstractReactiveMongoConfiguration {

	@Value("${mongo.uri}")
	String mongoUri;

	@Override
	protected String getDatabaseName() {
		return "customers";
	}

	@Override
	public MongoClient mongoClient() {
		return MongoClients.create(mongoUri);
	}
}
