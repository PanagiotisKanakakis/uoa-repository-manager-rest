package eu.dnetlib.repo.manager.api.application.rest;

import eu.dnetlib.domain.functionality.validator.JobForValidation;
import eu.dnetlib.domain.functionality.validator.RuleSet;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/validator")
public interface ValidatorApi {

    @RequestMapping(value = "/submitJobForValidation",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
    String submitJobForValidation(@RequestBody JobForValidation jobForValidation);

    @RequestMapping(value = "/getRuleSets" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    List<RuleSet> getRuleSets();

}
