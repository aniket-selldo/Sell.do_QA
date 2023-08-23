import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Testt2

{

	public static void main(String[] args) throws ConfigurationException {
		Configurations configs = new Configurations();
		Configuration config = configs.properties(new File(System.getProperty("user.dir") + "/config.properties"));

		System.out.println(config.getString("Logout"));
	}
}
