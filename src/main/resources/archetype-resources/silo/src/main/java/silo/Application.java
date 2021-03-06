#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId};

import com.rebuy.consul.EnableConsul;
import com.rebuy.library.messaging.annotation.EnableMessaging;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.nio.charset.Charset;

@SpringBootApplication
@EnableConfigurationProperties
@EnableMessaging
@EnableConsul
public class Application
{
    public static void main(String[] args)
    {
        if (!Charset.forName("UTF-8").equals(Charset.defaultCharset())) {
            throw new IllegalStateException("Default charset must be UTF-8");
        }

        new SpringApplicationBuilder()
            .bannerMode(Banner.Mode.OFF)
            .sources(Application.class)
            .run(args);
    }
}
