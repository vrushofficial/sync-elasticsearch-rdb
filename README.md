# sync-elasticsearch-rdb


In order to satisfy technical need to coordinate ElasticSearch with precreated RDBMS and without altering the existing project’s architecture, implement a logic to synchronize the database data and index it in ElasticSearch and perform complex querying without impacting the performance of the database in production.

In order to synchronize our data from MySQL with the user index in ElasticSearch, we’re gonna be using a Scheduler in which we will implement the synchronization logic.

Since we can’t sync all the records from the database each time the scheduler is running, we will add a modification date attribute to our user entity and use the UpdateTimestamp annotation to delegate the updating process of its value to Hibernate each time the entity will be changed.
Scheduler will run every 3 minutes, this period will change from a project to another depending on the importance of synched data.

In our syncUsers() method, we have two scenarios 

1) When the index is empty at the first launch of the application, we will send all the user records to ElasticSearch

2) Otherwise, we retrieve only the records that have been changed within the last INTERVAL_IN_MILLISECONDE starting from the time of the execution of the scheduler (as explained in the getModificationDatePredicate method above).


## To retrive data from ElasticSearch Engine

The body of the request will look something like this:

```
{
   "from": 0,
   "size": 100,
   "track_total_hits": true,
   "sort": {
      "id": {
         "order": "asc"
      }
   },
   "query": {
      "query_string": {
         "query": "*test*",
         "fields": [
            "firstName",
            "lastName"
         ],
         "default_operator": "AND"
      }
   },
   "highlight": {
      "fields": {
         "*": {}
      },
      "require_field_match": true
   }
}
```

Execute the post request with the body that we created earlier and wrap the response from ElasticSearch in the ResultQuery.

Tip: you can visualize the index content using the ElasticSearch Head extension in Chrome/Mozilla browsers.
