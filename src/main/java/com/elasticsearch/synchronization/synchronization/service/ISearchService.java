package com.elasticsearch.synchronization.synchronization.service;


import com.elasticsearch.synchronization.synchronization.utils.ResultQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface ISearchService {
    ResultQuery searchFromQuery(String query) throws IOException;
}
