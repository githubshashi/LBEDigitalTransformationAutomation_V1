package digitaltransformation.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import digitaltransformation.Pages.MyAccountClassD;
import digitaltransformation.Pages.MyAccountClassK;
import digitaltransformation.Pages.MyAccountCouncilTax_SubServices;
import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;

public class TC09_ClassK_ValidationCheck_SubmitCase extends BaseTest
{

	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassKConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	String Sub_ServicePageTitle="Portal- Create New Case · Ealing My Account";   // Title text of Council tax Sub service page list
	public static final String Sh_ClassK="ClassK";
	
	SoftAssert s_assert= new SoftAssert();
					
		@Test (groups = {"Apply_for_self"})
		public void ApplyForSelf() throws Exception 
		{		
			MyAccountCouncilTax_SubServices ct= new MyAccountCouncilTax_SubServices(driver);
			MyAccountClassK ck=new MyAccountClassK(driver);
			Utility ut=new Utility(driver);
			log4j_report.info("URL is opened");
			TestCasePass="Customer Selected Apply for self and Submitted case successfully";
			TestCaseFail="Customer is unable to Submit a case for Apply for self, 'Some thing went wrong' Please Check the Code";	
			TestCaseSkip="Test Case is Skipped for 'Submit a case for Apply for self' ";   
			String Casenumber=null;		
			int i=0;  // for Apply for yourself make i=0
			
			Explicitwait(hp.WhatSerivice_button,10);
			hp.Click_WhatSerivice();
			log4j_report.info("User clicked on What Service you are looking for");
			
			Explicitwait(hp.CouncilTax_linkbutton,10);
			hp.ClickonCounciltax();	
			log4j_report.info("User clicked on CouncilTax Service and CouncilTax Sub service Page is Opened ");
			logger.log(LogStatus.INFO, "Customer selected CouncilTax Service");
			
			Explicitwait(ct.ClassKServicelink,10);
			ct.ClickonclassKlink();	
			log4j_report.info("User clicked on ClassK SubService ");
			logger.log(LogStatus.INFO, "Customer selected ClassK Sub_SubService");
//			ut.Verify_SubService_titlepage();
			s_assert.assertEquals(driver.getTitle(), Sub_ServicePageTitle);
			
			
	//		ut.select_self_onbehalf(i);
			log4j_report.info("User selected for yourself option ");
			logger.log(LogStatus.INFO, "Customer selected Applyforself Option");
			
			Explicitwait(ut.StartFormbutton,5);
			ut.Click_StartForm();    //Introduction Page Start button Button, Start the form and case will be saved in draft state initially
			log4j_report.info("User clicked on Start Form ");
			logger.log(LogStatus.INFO, "Customer Clicked Start form");
			
			Explicitwait(ut.ReturnPage_HeadingText,10);
			s_assert.assertEquals(AccountNumber_heading, ut.Page_heading());
			ut.tickboxCouncilTaxAccNo();
			ut.NEXT_2();                         //Account Number page next button
			log4j_report.info("User Do tick on Check box (Manually Enter Details) and clicked on NEXT button");
			logger.log(LogStatus.INFO, "Customer View the Account Number page and Filled the details and clicked NEXT button ");
			
			Explicitwait(ut.ReturnPage_HeadingText,5);
			s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());
	
			ut.MandatoryFieldCheck();
			ut.Enter_CTAccountnumber(Utility.excelfilepath, 1, 2);
			ut.Postcode_SelectAddress(Sh_ClassK,1,2,3);    // Address of Unoccupied Property field (Sheetname, Row, Colunm, Dropdown) 
			ck.Enter_FirstName_PropertyVacated(Sh_ClassK, 1, 4);
			ck.Enter_LastName_PropertyVacated(Sh_ClassK, 1, 5);
			
			ut.telphonenumber();
			ut.NEXT_2();    //This method will click on Account Details page next button
			log4j_report.info("User View the Account Details Page and Filled all the details and clicked NEXT button");
			logger.log(LogStatus.INFO, "Customer View the Account Details Page and Filled all the details and clicked NEXT button ");
			
			s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
			ut.MandatoryFieldCheck();
			ck.Select_Owner_Tenant_PropertyUnoccupied(Sh_ClassK, 1, 6);
			ck.Enter_Date_propertyunoccupied(Sh_ClassK, 1, 7);
			ck.Select_AnyOtherAdultsResides(Sh_ClassK, 1, 8);
			ck.Enter_FirstName_Residents(Sh_ClassK, 1, 9);
			ck.Enter_LastName_Residents(Sh_ClassK, 1, 10);
			ck.Select_Person_student(Sh_ClassK, 1, 11);
			ck.Enter_ForwardingAddress(Sh_ClassK, 1, 12);
			ck.Enter_UniversityCollegeName(Sh_ClassK, 1, 13);
			ck.Enter_Course_StartDate(Sh_ClassK, 1, 14);
			ck.Enter_Course_EndDat(Sh_ClassK, 1, 15);
			ut.PostcodeOnbehalf_SelectAddress(Sh_ClassK, 1, 16, 17);
			ck.Enter_UniversityCollege_You_Studying(Sh_ClassK, 1, 18);
			ck.Enter_Course_You_StartDate(Sh_ClassK, 1, 19);
			ck.Enter_Course_You_EndDate(Sh_ClassK, 1, 20);
		
		
			ut.NEXT_2();            //This method will Click on Application Details page NEXT button
			log4j_report.info("User View the Application Details Page and Filled all the details and clicked NEXT button");
			logger.log(LogStatus.INFO, "Customer View the Application Details Page and Filled all the details and clicked NEXT button ");
			
			//ut.Uploadedocument();
			ut.NEXT_2();  //This method will click on Upload page NEXT button
			log4j_report.info("User Completes the Upload Page  and clicked NEXT button");
			logger.log(LogStatus.INFO, "Customer Completes the Upload Page  and clicked NEXT button ");
			
			s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
			ut.Select_summons(0);
			ut.ClickCheckBox();
			Explicitwait(ut.Submit_btn__DeclarationPage,10);
			ut.ClickSubmit_btn();
			log4j_report.info("User clicked Submit button");
			logger.log(LogStatus.INFO, "Customer  clicked Submit button ");
			
			s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
			String Service_Casenumber=ut.Casenumber(Casenumber);
			String AddScreenClassK=captureScrenshot(Screenshotname);	
			
			logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and Generated theCase number is: "+Service_Casenumber);
			
			ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassK,Service_Casenumber.substring(20, 30), 1, 1);
			
			logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassK));
			System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
			
			ut.ClickGotohome_btn();
			s_assert.assertAll();
			System.out.println("Test Run Compleed ");
		
		
		}		
		
		
}
