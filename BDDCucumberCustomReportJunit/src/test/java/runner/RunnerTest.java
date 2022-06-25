package runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)


@CucumberOptions(
features="src\\test\\resources\\featuree"
,glue="stepDefinations"
,monochrome= true
,publish = true
,plugin={"pretty"
		,"html:target/HtmlReports/cucumberhtmlreport.html"
		,"json:target/jsonReports/cucumberreportjson.json"}


)
public class RunnerTest {

	@AfterClass
	public static void generateReport() {
		String sdf=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File currentjsonfile=new File("C:\\Users\\MOHANRAJ\\Downloads\\5 june\\BDDCucumberCustomReport\\target\\jsonReports\\cucumberreportjson.json");
System.out.println(currentjsonfile);
		File newjsonfile=new File("C:\\Users\\MOHANRAJ\\Downloads\\5 june\\BDDCucumberCustomReport\\target\\jsonReports\\cucumberreportjson"+sdf+".json");
	System.out.println(newjsonfile);
		currentjsonfile.renameTo(newjsonfile);
		
		System.out.println("file renamed");
	File f=new File("C:\\Users\\MOHANRAJ\\Downloads\\5 june\\BDDCucumberCustomReport\\target\\jsonReports\\");
	File[] files= f.listFiles();
	System.out.println(files.length);
	List<String> jsonfile=new ArrayList();
	for(int i=0;i<files.length;i++) {
		jsonfile.add(files[i].getAbsolutePath());
		System.out.println(files[i].getAbsolutePath());

	}
	Configuration config=new Configuration(new File("C:\\Users\\MOHANRAJ\\Downloads\\5 june\\BDDCucumberCustomReport\\target"),"myproject");
		ReportBuilder reportbuilder=new ReportBuilder(jsonfile, config);
		reportbuilder.generateReports();
		System.out.println("completed");
	}
}
