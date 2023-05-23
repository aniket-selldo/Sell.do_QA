import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class test {

	private static Properties prop;

	static {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String browser = prop.getProperty("browser");
		String brwoserName = new String("chrome");
		
		System.out.println(browser.getClass().getName());

		System.out.println(browser.trim());
		System.out.println(brwoserName.strip());

		System.out.println(browser.equals(brwoserName));
		System.out.println(browser.equalsIgnoreCase(brwoserName));
	}
}
