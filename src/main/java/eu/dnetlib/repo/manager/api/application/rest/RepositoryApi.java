package eu.dnetlib.repo.manager.api.application.rest;

import eu.dnetlib.domain.data.Repository;
import eu.dnetlib.domain.data.RepositoryInterface;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/repository")
public interface RepositoryApi {

    @RequestMapping(value = "/getCountries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    String getCountries() ;

    @RequestMapping(value = "/getRepositoriesByCountry/{country}/{page}/{size}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<Repository> getRepositoriesByCountry(String country,
                                          String page,
                                          String size) ;

    @RequestMapping(value = "/getRepositoriesOfUser/{userEmail}/{page}/{size}")
    List<Repository> getRepositoriesOfUser( String userEmail,
                                        String page,
                                        String size);

    @RequestMapping(value = "/getRepositoryById/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Repository getRepositoryById(String id) ;

    @RequestMapping(value = "/getRepositoriesByName/{name}/{page}/{size}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<Repository> getRepositoriesByName(String name,
                                          String page,
                                          String size);

    @RequestMapping(value = "/getRepositoryInterface/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    RepositoryInterface getRepositoyInterface(String id) ;

    @RequestMapping(value = "/addRepository", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    String addRepository(Repository repository);

    @RequestMapping(value = "/addInterface", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    String addRepositoryInterface(RepositoryInterface repositoryInterface);

    @RequestMapping(value = "/getDnetCountries", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> getDnetCountries();

    @RequestMapping(value = "/getTypologies", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> getTypologies();

    @RequestMapping(value = "/getTimezones", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> getTimezones();

    @RequestMapping(value = "/updateManagedStatus", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String updateManagedStatus(String id,String managed);

    @RequestMapping(value = "/updateEnglishName", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String updateEnglishName(String id,String englishName);

    @RequestMapping(value = "/updateLatitude", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String updateLatitude(String id,String latitude);

    @RequestMapping(value = "/updateLongitude", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String updateLongitude(String id,String longitude);

    @RequestMapping(value = "/updateOfficialName", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String updateOfficialName(String id,String officialName);

    @RequestMapping(value = "/getUrlsOfUserRepos",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String getUrlsOfUserRepos(String user_email);

}
