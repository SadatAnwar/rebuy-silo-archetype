#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import com.fasterxml.jackson.databind.ObjectMapper;
import ${package}.${artifactId}.annotation.IntegrationTest;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.FilterChainProxy;
import com.rebuy.library.security.testhelper.AuthBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@Category(IntegrationTest.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(
    randomPort = true,
    value = {"spring.profiles.active=testing"}
)
public abstract class BaseIntegrationTest
{
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected FilterChainProxy filterChainProxy;

    @Autowired
    protected RemoteTokenServices remoteTokenServices;

    protected MockMvc mockMvc;

    protected AuthBuilder authBuilder = new AuthBuilder();

    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(filterChainProxy).build();
    }
}
