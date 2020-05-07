package utility;

import java.util.HashMap;
import java.util.Map;

public class Datagenerator {
	
	Map<String , String> Dataforpost = new HashMap <String , String>() ;
	public Map<String , String> createpayloadforpost(String name, String job) {
		Dataforpost.put("name", name) ;
		Dataforpost.put("Job", job) ;
	return Dataforpost ;
	}
	Map<String , String> Dataforput = new HashMap <String , String>() ;
	public Map<String , String> createpayloadforput(String job) {
		Dataforput.put("job", job) ;
		 ;
	return Dataforput ;
	}
}
