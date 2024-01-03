package A_Experiment;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {
	

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.compiler"));

		System.out.println(System.getProperty("os.arch"));

		System.out.println(System.getProperty("java.library.path"));

		System.out.println(System.getProperty("path.separator"));

		System.out.println(System.getProperty("file.separator"));

	

	}
	
//	-->  os.version              :  OS Version  
//	-->  os.name                 :  OS Name
//	-->  os.arch                 :  OS Architecture    
//	-->  java.compiler           :  Name of the compiler you are using
//	-->  java.ext.dirs           :  Extension directory path
//	-->  java.library.path       :  Paths to search libraries whenever loading
//	-->  path.separator          :  Path separator
//	-->  file.separator          :  File separator
//	-->  user.dir                :  Current working directory of User
//	-->  user.name               :  Account name of User
//	-->  java.vm.version         :  JVM implementation version
//	-->  java.vm.name            :  JVM implementation name
//	-->  java.home               :  Java installation directory
//	-->  java.runtime.version    :  JVM version

}
