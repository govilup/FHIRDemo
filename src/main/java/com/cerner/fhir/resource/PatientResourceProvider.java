package com.cerner.fhir.resource;

import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.IResourceProvider;
import com.cerner.fhir.util.PatientResourceUtil;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PatientResourceProvider implements IResourceProvider {

    public PatientResourceProvider() {}

    private Map<String, Patient> patientMap = new HashMap<>();

    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Patient.class;
    }

    @Search
    public List<Patient> search(@RequiredParam(name = Patient.SP_FAMILY) StringParam param) {
        return this.searchByFamilyName(param.getValue());
    }

    private List<Patient> searchByFamilyName(String familyName) {
        return PatientResourceUtil.loadDummyPatient(patientMap)
                .values().stream().filter(x -> familyName.toLowerCase()
                        .equals(x.getNameFirstRep().getFamily().toLowerCase()))
                .collect(Collectors.toList());
    }

    //ToDo: Read API
}
