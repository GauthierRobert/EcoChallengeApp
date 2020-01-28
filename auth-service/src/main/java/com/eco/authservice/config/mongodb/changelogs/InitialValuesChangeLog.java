package com.eco.authservice.config.mongodb.changelogs;

import com.eco.authservice.domain.AuthClientDetails;
import com.eco.authservice.domain.User;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.eco.authservice.domain.User.newUser;

@ChangeLog
public class InitialValuesChangeLog {

    @ChangeSet(order = "001", id = "insertBrowserClientDetails", author = "Gauthier Robert")
    public void insertBrowserClientDetails(MongoTemplate mongoTemplate) {
        AuthClientDetails browserClientDetails = new AuthClientDetails();
        browserClientDetails.setClientId("browser");
        browserClientDetails.setClientSecret("$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK");
        //1234
        browserClientDetails.setScopes("ui");
        browserClientDetails.setGrantTypes("refresh_token,password");

        mongoTemplate.save(browserClientDetails);
    }

    @ChangeSet(order = "002", id = "insertUserToTestAuthentication", author = "Gauthier Robert")
    public void insertUserToTestAuthentication(MongoTemplate mongoTemplate) {
        User user = newUser("randomuser", "$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK");
        mongoTemplate.save(user);
    }

    @ChangeSet(order = "003", id = "insertChallengeServiceClientDetails", author = "Gauthier Robert")
    public void insertChallengeServiceClientDetails(MongoTemplate mongoTemplate) {
        mongoTemplate.save(createAuthUser("challenge-service", "$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK"));
    }

    @ChangeSet(order = "004", id = "insertChallengePlayerServiceClientDetails", author = "Gauthier Robert")
    public void insertChallengePlayerServiceClientDetails(MongoTemplate mongoTemplate) {
        mongoTemplate.save(createAuthUser("challenge-player-service", "$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK"));
    }


    @ChangeSet(order = "005", id = "insertUserServiceClientDetails", author = "Gauthier Robert")
    public void insertUserServiceClientDetails(MongoTemplate mongoTemplate) {
        mongoTemplate.save(createAuthUser("user-service", "$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK"));
    }

    @ChangeSet(order = "006", id = "insertPlayerServiceClientDetails", author = "Gauthier Robert")
    public void insertPlayerServiceClientDetails(MongoTemplate mongoTemplate) {
        mongoTemplate.save(createAuthUser("player-service", "$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK"));
    }

    private AuthClientDetails createAuthUser(String username, String password){
        AuthClientDetails challengeServiceClientDetails = new AuthClientDetails();
        challengeServiceClientDetails.setClientId(username);
        challengeServiceClientDetails.setClientSecret(password);
        challengeServiceClientDetails.setScopes("server");
        challengeServiceClientDetails.setGrantTypes("refresh_token,client_credentials");
        return challengeServiceClientDetails;
    }

}