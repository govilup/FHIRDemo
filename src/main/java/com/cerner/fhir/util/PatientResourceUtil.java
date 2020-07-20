package com.cerner.fhir.util;

import org.hl7.fhir.r4.model.Patient;

import java.util.Map;

public class PatientResourceUtil {

    public static Map<String, Patient> loadDummyPatient(Map<String, Patient> patientMap) {
        Patient patient = new Patient();
        patient.setId("1");
        patient.addIdentifier().setSystem("http://cerner.com").setValue("007");
        patient.addName().setFamily("Chakravarty").addGiven("Mithun").addGiven("A");
        patient.addAddress().addLine("Address Line 1");
        patient.addAddress().setCity("Mumbai");
        patient.addAddress().setCountry("India");
        patient.addTelecom().setValue("111-111-1111");
        patientMap.put("1", patient);

        for (int i = 2; i < 5; i++) {
            patient = new Patient();
            patient.setId(Integer.toString(i));
            patient.addIdentifier().setSystem("http://optum.com/MRNs").setValue("007" + i);
            patient.addName().setFamily("Bond" + i).addGiven("James").addGiven("J");
            patient.addAddress().addLine("House Line " + i);
            patient.addAddress().setCity("Your City");
            patient.addAddress().setCountry("USA");
            patientMap.put(Integer.toString(i), patient);
        }
        return patientMap;
    }
}
