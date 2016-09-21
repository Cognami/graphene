package graphene.util.fs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestFileUtils {

	@Test
	public void confirmWindowsRegex() {
		Pattern p = Pattern.compile(FileUtils.ENVIRONMENTAL_VAR_REGEX);
		Matcher m = p.matcher("%TOMCAT_HOME%"); // get a matcher object
		AssertJUnit.assertTrue(m.find());
		AssertJUnit.assertEquals("TOMCAT_HOME", m.group(3));
	}

	@Test
	public void confirmUnixRegex1() {
		Pattern p = Pattern.compile(FileUtils.ENVIRONMENTAL_VAR_REGEX);
		Matcher m = p.matcher("${TOMCAT_HOME}"); // get a matcher object
		AssertJUnit.assertTrue(m.find());
		AssertJUnit.assertEquals("TOMCAT_HOME", m.group(1));
	}

	@Test
	public void confirmUnixRegex2() {
		Pattern p = Pattern.compile(FileUtils.ENVIRONMENTAL_VAR_REGEX);
		Matcher m = p.matcher("$TOMCAT_HOME"); // get a matcher object
		AssertJUnit.assertTrue(m.find());
		AssertJUnit.assertEquals("TOMCAT_HOME", m.group(2));
	}





}
