package A_Experiment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class asas {

	public static String prop(String propee) {
		Configurations configs = new Configurations();
		Configuration config = null;
		try {
			config = configs.properties(new File(System.getProperty("user.dir") + "/config.properties"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> ls = new ArrayList<>();
		ls.add("aniket.khandizod@sell.do");
		ls.add("prerana.hotkar@sell.do");
		ls.add("hakim.rangwala@sell.do");
		ls.add("sagar.shejal@sell.do");
		ls.add("shyam.pandav@sell.do");
		ls.add("parth.bharadiya@sell.do");
		String systemName = System.getProperty("user.name");
		String value =ls.stream().filter(S->S.startsWith(systemName.substring(0,6))).findFirst().get();
		config.setProperty("Email",value);
		return config.getString(propee);
	}
}
