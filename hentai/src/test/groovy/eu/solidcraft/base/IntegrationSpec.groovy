package eu.solidcraft.base

import eu.solidcraft.AppRunner
import eu.solidcraft.infrastructure.config.Profiles
import groovy.transform.TypeChecked
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import spock.lang.Specification
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.*
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*

@TypeChecked
@ActiveProfiles([Profiles.INTEGRATION])
@SpringBootTest(classes = [AppRunner])
abstract class IntegrationSpec extends Specification {
    @Autowired
    protected WebApplicationContext webApplicationContext

    MockMvc mockMvc

    @Before
    void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                        .apply(springSecurity())
                        .build()
    }
}
