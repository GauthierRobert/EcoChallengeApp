package com.eco.contestservice.domain;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contest {

        @Id
        private String id;

        private String password;

        private List<String> players;

        private List<String> Challenges;

}
