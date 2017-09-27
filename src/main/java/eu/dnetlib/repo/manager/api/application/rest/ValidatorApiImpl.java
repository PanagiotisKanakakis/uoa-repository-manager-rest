package eu.dnetlib.repo.manager.api.application.rest;

import gr.uoa.di.driver.util.ServiceLocator;
import eu.dnetlib.domain.functionality.validator.JobForValidation;
import eu.dnetlib.domain.functionality.validator.RuleSet;
import eu.dnetlib.repo.manager.api.application.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import eu.dnetlib.api.functionality.ValidatorService;
import org.springframework.stereotype.Component;

@Component
public class ValidatorApiImpl implements ValidatorApi{

    private ServiceLocator<ValidatorService> validatorServiceLocator;

    private ValidatorService getValidationService() {
        return this.validatorServiceLocator.getService();
    }

    public ServiceLocator<ValidatorService> getValidatorServiceLocator() {
        return validatorServiceLocator;
    }

    public void setValidatorServiceLocator(ServiceLocator<ValidatorService> validatorServiceLocator) {
        this.validatorServiceLocator = validatorServiceLocator;
    }

    @Override
    public String submitJobForValidation(JobForValidation jobForValidation) {
        return null;
    }

    @Override
    public List<RuleSet> getRuleSets() {

        Map<String, List<RuleSet>> rulesetMap = new ConcurrentHashMap<String, List<RuleSet>>();

        try {
            for (RuleSet ruleSet : getValidationService().getRuleSets()) {
                if (ruleSet.getVisibility() != null && ruleSet.getVisibility().contains("development")) {
                    String key = "";
                    if (ruleSet.getGuidelinesAcronym().matches("^openaire[1-9].0_data$"))
                        key = Constants.VALIDATION_MODE_DATA;
                    else if (ruleSet.getGuidelinesAcronym().matches("^openaire[1-9].0$") || ruleSet.getGuidelinesAcronym().equals("driver"))
                        key = Constants.VALIDATION_MODE_LITERATURE;
                    else if (ruleSet.getGuidelinesAcronym().matches("^openaire[1-9].0_cris$"))
                        key = Constants.VALIDATION_MODE_CRIS;

                    if (rulesetMap.containsKey(key))
                        rulesetMap.get(key).add(ruleSet);
                    else {
                        List<RuleSet> ruleSets = new ArrayList<RuleSet>();
                        ruleSets.add(ruleSet);
                        rulesetMap.put(key, ruleSets);
                    }
                    System.out.println(ruleSet.getContentRules());
                }
            }
            return rulesetMap.get(Constants.VALIDATION_MODE_DATA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
