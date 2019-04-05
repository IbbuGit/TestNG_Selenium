package testDataTypes;

import com.opencsv.bean.CsvBindByName;

public class MyHomeData {
	@CsvBindByName(column = "dataScenarios")
	public String dataScenarios;
	@CsvBindByName(column = "temp")
	public String temp;
}
