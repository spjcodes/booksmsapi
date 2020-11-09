package com.spj.booksms.tools;


import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;

public class SolrQueryTools {

    @Autowired
    SolrClient solrClient;

    SolrClient getSolClient() {
        return solrClient;
    }

    void test() {
//        solrClient.add
    }
}
