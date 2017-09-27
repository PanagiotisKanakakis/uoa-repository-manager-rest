package eu.dnetlib.repo.manager.api.application.rest;

import eu.dnetlib.repo.manager.api.application.utils.Utils;
import eu.dnetlib.domain.data.Repository;
import eu.dnetlib.domain.data.RepositoryInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Component
public class RepositoryApiImpl implements RepositoryApi {

    @Value("${api.baseAddress}")
    private String baseAddress;

    @Override
    public String getCountries()  {
        return RestService.executeGET(baseAddress + "/ds/countries");
    }


    @Override
    public List<Repository> getRepositoriesByCountry(@PathVariable("country") String country,
                                                     @PathVariable("page") String page,
                                                     @PathVariable("size") String size){
        String vars = page+"/"+size+"?country="+country;
        String uri = baseAddress+ "/ds/search/country/" + vars;
        JSONArray jsonArray = new JSONArray(RestService.executeGET(uri));
        return Utils.jsonToRepositoryList(jsonArray);
    }

    @Override
    public List<Repository> getRepositoriesOfUser(@PathVariable("userEmail") String userEmail,
                                                  @PathVariable("page") String page,
                                                  @PathVariable("size") String size)  {
        String vars = page+"/"+size+"?contactemail="+userEmail;
        String uri = baseAddress+ "/ds/search/email/" + vars;
        JSONArray jsonArray = new JSONArray(RestService.executeGET(uri));
        return Utils.jsonToRepositoryList(jsonArray);
    }

    @Override
    public Repository getRepositoryById(@PathVariable("id") String id)  {
        String uri = baseAddress+ "/ds/get/" + id;
        JSONObject jsonObject = new JSONObject( RestService.executeGET(uri) );
        return  Utils.jsonToRepositoryObject(jsonObject);
    }

    @Override
    public List<Repository> getRepositoriesByName(@PathVariable("name") String name,
                                                  @PathVariable("page") String page,
                                                  @PathVariable("size") String size) {
        String vars = page+"/"+size+"?name="+name;
        String uri = baseAddress+ "/ds/search/name/" + vars;
        JSONArray jsonArray = new JSONArray(RestService.executeGET(uri));
        return Utils.jsonToRepositoryList(jsonArray);
    }

    @Override
    public RepositoryInterface getRepositoyInterface(@PathVariable("id") String id) {
        String uri = baseAddress+ "/ds/api/" + id;
        JSONArray jsonArray = new JSONArray( RestService.executeGET(uri) );
        return  Utils.jsonToRepositoryInterfaceObject(jsonArray.getJSONObject(0));
    }

    @Override
    public String addRepository(@RequestBody Repository repository) {
        String uri = baseAddress+ "/ds/add/";
        return RestService.executePOST(uri,Utils.repositoryObjectToJson(repository));
    }

    @Override
    public String addRepositoryInterface(RepositoryInterface repositoryInterface) {
        String uri = baseAddress+ "/ds/api/add/";
        return RestService.executePOST(uri,Utils.repositoryInterfaceObjectToJson(repositoryInterface));
    }

    @Override
    public List<String> getDnetCountries() {
        return Utils.readFile("countries.txt");
    }

    @Override
    public List<String> getTypologies() {
        return Utils.readFile("typologies.txt");
    }

    @Override
    public List<String> getTimezones() {
        return Utils.readFile("timezones.txt");
    }

    @Override
    public String updateManagedStatus(@RequestParam(value = "id")   String id,
                                      @RequestParam(value = "managed")  String managed) {
        String uri = baseAddress+ "/ds/manage?id="+id+"&managed="+managed;
        return RestService.executePOST(uri,null);
    }

    @Override
    public String updateEnglishName(@RequestParam(value = "id")   String id,
                                    @RequestParam(value = "englishname")  String englishName) {
        String uri = baseAddress+ "/ds/manage?dsId="+id+"&englishname="+englishName;
        return RestService.executePOST(uri,null);
    }

    @Override
    public String updateLatitude(@RequestParam(value = "id")   String id,
                                 @RequestParam(value = "managed")  String latitude) {
        String uri = baseAddress+ "/ds/manage?dsId="+id+"&latitude="+latitude;
        return RestService.executePOST(uri,null);
    }

    @Override
    public String updateLongitude(@RequestParam(value = "id")   String id,
                                  @RequestParam(value = "longitude")  String longitude) {
        String uri = baseAddress+ "/ds/manage?dsId="+id+"&longitude="+longitude;
        return RestService.executePOST(uri,null);
    }

    @Override
    public String updateOfficialName(@RequestParam(value = "id")   String id,
                                     @RequestParam(value = "officialname")  String officialname) {
        String uri = baseAddress+ "/ds/manage?dsId="+id+"&officialname="+officialname;
        return RestService.executePOST(uri,null);
    }

    @Override
    public String getUrlsOfUserRepos(@PathVariable("user_email") String user_email) {

        //TODO create api a join datasource d for user u method

        return null;
    }


}
