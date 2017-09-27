package eu.dnetlib.repo.manager.api.application.utils;

import eu.dnetlib.domain.data.Repository;
import eu.dnetlib.domain.data.RepositoryInterface;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.rmi.CORBA.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    public static Repository jsonToRepositoryObject(JSONObject jsonObject) {

        Repository repository = new Repository();
        JSONObject datasource = (JSONObject) jsonObject.get("datasource");

        repository.setActivationId(datasource.get("activationId").toString());
        repository.setAggregator(datasource.get("aggregator").toString());
        repository.setCertificates(datasource.get("certificates").toString());
        repository.setCitationGuidelineUrl(datasource.get("citationguidelineurl").toString());
        repository.setCollectedFrom( datasource.get("collectedfrom").toString());
        repository.setContactEmail(datasource.get("contactemail").toString());
        repository.setDatabaseAccessRestriction(datasource.get("databaseaccessrestriction").toString());
        repository.setDatabaseAccessType(datasource.get("databaseaccesstype").toString());
        repository.setDataUploadRestriction(datasource.get("datauploadrestriction").toString());
        repository.setDataUploadType(datasource.get("datauploadtype").toString());
        repository.setDateOfCollection(convertDate( datasource.get("dateofcollection").toString()));
        repository.setDateOfValidation(convertDate( datasource.get("dateofvalidation").toString()));
        repository.setDescription(datasource.get("description").toString());
        repository.setEissn(datasource.get("eissn").toString());
        repository.setEnglishName( datasource.get("englishname").toString());
        repository.setId(datasource.get("id").toString());
        repository.setIssn(datasource.get("issn").toString());
        repository.setOdLanguages(datasource.get("languages").toString());
        repository.setLatitude( toDouble(datasource.get("latitude").toString()));
        repository.setLissn(datasource.get("lissn").toString());
        repository.setLogoUrl(datasource.get("logourl").toString());
        repository.setLongitude(toDouble(datasource.get("longitude").toString()));
        //datasource.get("managed");
        repository.setMissionStatementUrl(datasource.get("missionstatementurl").toString());
        repository.setNamespacePrefix(datasource.get("namespaceprefix").toString());
        repository.setOdContentTypes(datasource.get("od_contenttypes").toString());
        repository.setOfficialName(datasource.get("officialname").toString());
        repository.setPidSystems(datasource.get("pidsystems").toString());
        //datasource.get("platform");
        repository.setProvenanceActionClass( datasource.get("provenanceaction").toString());
        repository.setQualityManagementKind(datasource.get("qualitymanagementkind").toString());
        repository.setRegisteredBy(datasource.get("registeredby").toString());
        repository.setReleaseEndDate(convertDate(datasource.get("releaseenddate").toString()));
        repository.setReleaseStartDate(convertDate(datasource.get("releasestartdate").toString()));
        repository.setServiceProvider(Boolean.valueOf(datasource.get("serviceprovider").toString()));
        //datasource.get("subjects");
        Double timezone = toDouble(datasource.get("timezone").toString());
        repository.setTimezone(timezone!=null?timezone:0.0);
        repository.setTypology(datasource.get("typology").toString());
        repository.setVersioning(Boolean.valueOf(datasource.get("versioning").toString()));
        repository.setWebsiteUrl(datasource.get("websiteurl").toString());
        return repository;
    }

    public static Date convertDate(String date){

        if(Objects.equals(date, "null"))
            return null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertDateToString(String date){

        if(Objects.equals(date, "null"))
            return null;

        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

        Date d = null;
        try {
            d = (Date)formatter.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            return cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double toDouble(String number){
        if(Objects.equals(number, "null"))
            return null;
        else
            return Double.valueOf(number);
    }

    public static List<Repository> jsonToRepositoryList(JSONArray rs) {

        List<Repository> resultSet = new ArrayList<>();
        for(int i=0;i<rs.length();i++)
            resultSet.add(jsonToRepositoryObject( rs.getJSONObject(i)) );
        return resultSet;
    }

    public static RepositoryInterface jsonToRepositoryInterfaceObject(JSONObject jsonObject) {

        RepositoryInterface repositoryInterface = new RepositoryInterface();

        repositoryInterface.setBaseUrl(jsonObject.get("baseurl").toString());
        repositoryInterface.setContentDescription(jsonObject.get("contentdescription").toString());
        repositoryInterface.setId(jsonObject.get("id").toString());
        repositoryInterface.setMetadataIdentifierPath(jsonObject.get("metadataIdentifierPath").toString());
        repositoryInterface.setAccessProtocol(jsonObject.get("protocol").toString());
        repositoryInterface.setTypology(jsonObject.get("typology").toString());
        repositoryInterface.setDesiredCompatibilityLevel(jsonObject.get("compatibility").toString());
        repositoryInterface.setActive(Boolean.parseBoolean(jsonObject.get("active").toString()));
        repositoryInterface.setRemovable(Boolean.parseBoolean(jsonObject.get("removable").toString()));

        return repositoryInterface;
    }

    public static String repositoryObjectToJson(Repository repository) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("activationId",repository.getActivationId());
        jsonObject.put("aggregator",repository.getAggregator());
        jsonObject.put("certificates",repository.getCertificates());
        jsonObject.put("citationguidelineurl",repository.getCitationGuidelineUrl());
        jsonObject.put("collectedfrom",repository.getCollectedFrom());
        jsonObject.put("contactemail",repository.getContactEmail());
        jsonObject.put("databaseaccessrestriction",repository.getDatabaseAccessRestriction());
        jsonObject.put("databaseaccesstype",repository.getDatabaseAccessType());
        jsonObject.put("datauploadrestriction",repository.getDataUploadRestriction());
        jsonObject.put("datauploadtype",repository.getDataUploadType());
        jsonObject.put("dateofcollection",convertDateToString(String.valueOf(repository.getDateOfCollection())));
        jsonObject.put("dateofvalidation",convertDateToString(String.valueOf(repository.getDateOfValidation())));
        jsonObject.put("description",repository.getDescription());
        jsonObject.put("eissn",repository.getEissn());
        jsonObject.put("englishname",repository.getEnglishName());
        jsonObject.put("id",repository.getId());
        jsonObject.put("issn",repository.getIssn());
        jsonObject.put("languages",repository.getOdLanguages());
        jsonObject.put("latitude",repository.getLatitude().toString());
        jsonObject.put("lissn",repository.getLissn());
        jsonObject.put("logourl",repository.getLogoUrl());
        jsonObject.put("longitude",repository.getLongitude().toString());
        jsonObject.put("missionstatementurl",repository.getMissionStatementUrl());
        jsonObject.put("namespaceprefix",repository.getNamespacePrefix());
        jsonObject.put("od_contenttypes",repository.getOdContentTypes());
        jsonObject.put("officialname",repository.getOfficialName());
        jsonObject.put("pidsystems",repository.getPidSystems());
        jsonObject.put("provenanceaction",repository.getProvenanceActionClass());
        jsonObject.put("qualitymanagementkind",repository.getQualityManagementKind());
        jsonObject.put("registeredby",repository.getRegisteredBy());
        jsonObject.put("releaseenddate",convertDateToString(String.valueOf(repository.getReleaseEndDate())));
        jsonObject.put("releasestartdate",convertDateToString(String.valueOf(repository.getReleaseStartDate())));
        jsonObject.put("serviceprovider",repository.getServiceProvider());
        jsonObject.put("timezone",repository.getTimezone());
        jsonObject.put("typology",repository.getTypology());
        jsonObject.put("versioning",repository.getVersioning());
        jsonObject.put("websiteurl",repository.getWebsiteUrl());

        //datasource.get("managed");
        //datasource.get("platform");
        //datasource.get("subjects");
        return jsonObject.toString();
    }

    public static String repositoryInterfaceObjectToJson(RepositoryInterface repositoryInterface) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("baseurl",repositoryInterface.getBaseUrl());
        jsonObject.put("contentdescription",repositoryInterface.getContentDescription());
        jsonObject.put("id",repositoryInterface.getId());
        jsonObject.put("metadataIdentifierPath",repositoryInterface.getMetadataIdentifierPath());
        jsonObject.put("protocol",repositoryInterface.getAccessProtocol());
        jsonObject.put("typology",repositoryInterface.getTypology());
        jsonObject.put("compatibility",repositoryInterface.getDesiredCompatibilityLevel());
        //jsonObject.put("removable",repositoryInterface.getRemovable());
        //jsonObject.put("active",repositoryInterface.getActive());
        return jsonObject.toString();
    }

    public static ArrayList<String> readFile(String filename) {
        String line;
        ArrayList<String> list = new ArrayList<String>();
        try {
            File file = new File(Utils.class.getResource("/eu/dnetlib/repo/manager/api/"+filename).getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null) {
                list.add(line.trim());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}