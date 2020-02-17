package com.eco.challengeservice.resource;

import com.eco.challengeservice.dto.ChallengeDto;
import com.eco.challengeservice.service.ChallengeService;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/challenge")
@Produces(APPLICATION_JSON + "; charset=UTF-8")
@Consumes(APPLICATION_JSON + "; charset=UTF-8")
@Named
public class ChallengeResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ChallengeConverter converter;
    @Inject
    private ChallengeService challengeService;

    @GET
    @Path("/findAll")
    public Collection<ChallengeDto> findAll(){
        return challengeService.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    @GET
    @Path("/findAll/{level}")
    public Collection<ChallengeDto> findAllByLevel(@PathParam("level") int level){
        return challengeService.findAllByLevel(level).stream().map(converter::convert).collect(Collectors.toList());
    }

}
