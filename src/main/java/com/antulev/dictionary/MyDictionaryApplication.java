package com.antulev.dictionary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.antulev.dictionary.aban.DbLoader;

@SpringBootApplication
public class MyDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDictionaryApplication.class, args);
	}
	@Bean
    CommandLineRunner init(DbLoader dbLoader) {
        return (args) -> {
        	dbLoader.clean();
        	dbLoader.init();
        };
    }
}

