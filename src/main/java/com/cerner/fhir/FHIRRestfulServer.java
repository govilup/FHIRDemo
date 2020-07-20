package com.cerner.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.RestfulServer;
import com.cerner.fhir.resource.PatientResourceProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/*")
public class FHIRRestfulServer extends RestfulServer {

    @Override
    protected void initialize() throws ServletException {
        setFhirContext(FhirContext.forR4());
        registerProvider(new PatientResourceProvider());
    }
}
