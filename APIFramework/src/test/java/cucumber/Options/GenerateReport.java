package cucumber.Options;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {
    public static void main(String[] args) {
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/jsonReports/cucumber-report.json");

        String buildNumber = "1";
        String projectName = "CucumberProject";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
