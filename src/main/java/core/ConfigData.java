package core;

import com.opencsv.bean.CsvBindByName;

public class ConfigData {
	@CsvBindByName(column = "dataScenarios")
	public String dataScenarios;
	@CsvBindByName(column = "browser")
	public String browser;
	@CsvBindByName(column = "URL")
	public String URL;
}
