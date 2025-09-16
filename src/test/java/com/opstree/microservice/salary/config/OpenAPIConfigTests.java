package com.opstree.microservice.salary.swagger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = OpenAPIConfig.class)
class OpenAPIConfigTest {

    @Test
    void testOpenAPIConfiguration() {
        // Load the Spring context and retrieve the OpenAPI bean
        OpenAPI openAPI = new OpenAPIConfig().myOpenAPI();

        // Verify that the OpenAPI object is not null
        assertNotNull(openAPI);

        // Verify the server details
        assertEquals(3, openAPI.getServers().size());
        Server devserver = openAPI.getServers().get(0);
        assertEquals("http://13.200.245.13:8082", devserver.getUrl());
        assertEquals("Server URL in Development environment", devserver.getDescription());

        Server albserver = openAPI.getServers().get(1);
        assertEquals("http://ot-ms-load-balancer-1191154576.ap-south-1.elb.amazonaws.com/swagger-ui/index.html", albserver.getUrl());
        assertEquals("Server URL in Development environment", albserver.getDescription());

            
        Server albbserver = openAPI.getServers().get(2);
        assertEquals("http://ot-ms-load-balancer-1191154576.ap-south-1.elb.amazonaws.com/actuator/health", albbserver.getUrl());
        assertEquals("Server URL in Development environment", albbserver.getDescription());
 
        // Verify the contact details
        Contact contact = openAPI.getInfo().getContact();
        assertEquals("opensource@opstree.com", contact.getEmail());
        assertEquals("Opstree Solutions", contact.getName());
        assertEquals("https://opstree.com", contact.getUrl());

        // Verify the license details
        License license = openAPI.getInfo().getLicense();
        assertEquals("MIT License", license.getName());
        assertEquals("https://choosealicense.com/licenses/mit/", license.getUrl());

        // Verify other general info details
        assertEquals("Salary Microservice API", openAPI.getInfo().getTitle());
        assertEquals("1.0", openAPI.getInfo().getVersion());
        assertEquals("This API exposes endpoints to manage salary information.", openAPI.getInfo().getDescription());
        assertEquals("https://www.opstree.com/terms", openAPI.getInfo().getTermsOfService());
    }
}

