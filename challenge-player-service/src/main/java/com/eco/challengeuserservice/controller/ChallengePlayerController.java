package com.eco.challengeuserservice.controller;

import com.eco.challengeuserservice.converter.ChallengePlayerConverter;
import com.eco.challengeuserservice.dto.ChallengePlayerDto;
import com.eco.challengeuserservice.service.ChallengePlayerService;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static java.util.stream.Collectors.toList;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/challenge-player")
@Produces(APPLICATION_JSON + "; charset=UTF-8")
@Consumes(APPLICATION_JSON + "; charset=UTF-8")
@Named
public class ChallengePlayerController {

    @Inject
    private ChallengePlayerService service;

    @Inject
    private ChallengePlayerConverter converter;

    @GET
    @Path("/{playerId}")
    public Collection<ChallengePlayerDto> findAll(@PathParam("playerId") String playerId) {
        return service.findByPlayerId(playerId).stream().map(converter::convert).collect(toList());
    }

    @PUT
    @Path("/{challengePlayerId}")
    public ChallengePlayerDto validate(@PathParam("challengePlayerId") String challengePlayerId) {
        return converter.convert(service.validate(challengePlayerId));
    }

}
