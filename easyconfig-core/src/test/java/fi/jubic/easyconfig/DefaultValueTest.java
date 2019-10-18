package fi.jubic.easyconfig;

import fi.jubic.easyconfig.annotations.EasyConfigProperty;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultValueTest {
    @Test
    public void testConstructorParametersMapping() throws MappingException {
        TestConfig config = new ConfigMapper(envProvider)
                .read(TestConfig.class);

        assertThat(config.getId(), is(111L));
        assertThat(config.getHost(), is("127.1.0.1"));
    }

    private static EnvProvider envProvider = new StaticEnvProvider();

    static class TestConfig {
        private final Long id;
        private final String host;

        public TestConfig(
                @EasyConfigProperty(
                        value = "ID",
                        defaultValue = "111"
                ) Long id,
                @EasyConfigProperty(
                        value = "HOST",
                        defaultValue = "127.1.0.1"
                ) String host
        ) {
            this.id = id;
            this.host = host;
        }

        Long getId() {
            return id;
        }

        String getHost() {
            return host;
        }
    }
}
