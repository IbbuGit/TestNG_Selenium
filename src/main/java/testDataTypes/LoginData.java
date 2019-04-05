package   testDataTypes;

import com.opencsv.bean.CsvBindByName;

public class LoginData {
	
	@CsvBindByName(column = "dataScenarios")
	public String dataScenarios;
	@CsvBindByName(column = "username")
	public String username;
	@CsvBindByName(column = "password")
	public String password;
	@CsvBindByName(column = "errMsg")
	public String errMsg;
	@CsvBindByName(column = "loginButton_text")
	public String loginButton_text;
	
	

}