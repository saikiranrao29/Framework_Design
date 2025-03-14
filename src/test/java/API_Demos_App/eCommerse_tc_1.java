package API_Demos_App;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtils.Android_BaseTest;
import UDC_Android_UserDefinedClasses.UDC_API_Demos_Android;

//General Store E-Commerse Application

public class eCommerse_tc_1 extends Android_BaseTest{
	
	@Test (dataProvider = "APIDemoTestData")
	public void addToCart(String stext,String Name,String typeOfGender) throws URISyntaxException, IOException {
		
		InstallApplication();
		UDC_API_Demos_Android UDC= new UDC_API_Demos_Android(driver);
		UDC.AlertValidation(stext);
		UDC.GoToProducts(Name,typeOfGender);
		}
	
	@DataProvider
	public Object[] [] APIDemoTestData() {
		
	return new Object [] [] {
		{"Argentina","Sai Kiran Rao","Female"}
							};
	}
}

