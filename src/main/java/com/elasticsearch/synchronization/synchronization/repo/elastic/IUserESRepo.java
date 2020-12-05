package com.elasticsearch.synchronization.synchronization.repo.elastic;

import com.elasticsearch.synchronization.synchronization.model.UserModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IUserESRepo extends ElasticsearchRepository<UserModel, Long> {
}
