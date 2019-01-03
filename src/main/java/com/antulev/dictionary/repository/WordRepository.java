package com.antulev.dictionary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.antulev.dictionary.model.Word;

public interface WordRepository extends PagingAndSortingRepository<Word, String>{
	Page<Word> findByBaseTextIgnoreCaseStartsWith(String baseText, Pageable pageable);
	boolean existsByBaseText(String baseText);
	Word findFirstByBaseText(String BaseText);
}
