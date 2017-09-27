package eu.dnetlib.repo.manager.api.application.utils;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Created by nikonas on 23/12/15.
 */

public class Constants implements IsSerializable {

    public static final String MODE_LOCAL = "local";
    public static final String MODE_DNET = "dnet";
    public static final String MODE_LDAP = "ldap";
    public static final String ENV_LAREFERENCIA = "lareferencia";

    public static final String ENV_MINCYT = "mincyt";
    public static final String ENV_OPENAIRE_PRODUCTION = "openaire-production";
    public static final String ENV_OPENAIRE_BETA = "openaire-beta";
    public static final String ENV_DEVELOPMENT = "development";
    public static final String LATITUDE_PATTERN = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";

    public static final String LONGITUDE_PATTERN = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$";
    public static final String EMAIL_PATTERN = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";


    public static final String REPOSITORY_MODE_OPENDOAR = "opendoar";
    public static final String REPOSITORY_MODE_RE3DATA = "re3data";
    public static final String REPOSITORY_MODE_JOURNAL = "journal";
    public static final String REPOSITORY_MODE_AGGREGATOR = "aggregator";
    public static final String REPOSITORY_MODE_ALL = "all";

    public static final String VALIDATION_MODE_LITERATURE = "literature";
    public static final String VALIDATION_MODE_DATA = "data";
    public static final String VALIDATION_MODE_CRIS = "cris";

    public static final String VALIDATION_JOB_TYPE_COMPATIBILITY_TEST = "Compatibility Test";
    public static final String VALIDATION_JOB_TYPE_REGISTRATION_REQUEST = "Registration Request";
    public static final String VALIDATION_JOB_TYPE_WORKFLOW_REQUEST = "Workflow Request";

    public static final String VALIDATION_JOB_STATUS_SUCCESSFUL = "successful";
    public static final String VALIDATION_JOB_STATUS_FAILED = "failed";
    public static final String VALIDATION_JOB_STATUS_ONGOING = "ongoing";

}
