package digitaltransformation.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;


import digitaltransformation.Pages.MyAccountClassV;
import digitaltransformation.Pages.MyAccountCouncilTax_SubServices;
import digitaltransformation.Utilities.ExcelReadWrite;
import digitaltransformation.Utilities.Utility;



public class TC15_ClassV_ValidationCheck_SubmitCase  extends BaseTest
{
	String AccountNumber_heading= "Account number"; 						//Council tax Account number Page heading text
	String AccountDetails_heading= "Account details"; 						//Council tax Account Details Page heading text
	String AppDetails_heading= "Application details"; 					//Council tax Application details Page heading text
	String Support_Info_Declaration_heading= "Supporting information and declaration"; //Council tax Declaration Page heading text
	String ServiceSummary_heading= "Service summary"; 						//Council tax Service summary Page heading text
	String Screenshotname="ClassDConfirmationScreen";  							//Screen shot name.
	String Delegation_heading="Please complete details of the person you wish to act on behalf of.";  //Common delegation	
	String Sub_ServicePageTitle="Portal- Create New Case · Ealing My Account";   // Title text of Council tax Sub service page list


	 public String SelectbyIndex = "Index";   // Drop down selection by index
	 public String Selectbyvalue = "value";		// Drop down selection by value
	 public String SelectbyVisibletext = "visibletext";  	// Drop down selection by Visible text
	
	public static final String Sh_ClassV="ClassV";
	
	SoftAssert s_assert= new SoftAssert();
				
	@Test (groups = {"Apply_for_self"})
	public void ApplyForSelf() throws Exception 
	{		
			
		MyAccountCouncilTax_SubServices ct= new MyAccountCouncilTax_SubServices(driver);
		MyAccountClassV cv=new MyAccountClassV(driver);
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
		
		Explicitwait(ct.ClassVServicelink,10);
		ct.ClickonclassVlink();	
		log4j_report.info("User clicked on ClassV SubService ");
		logger.log(LogStatus.INFO, "Customer selected ClassV Sub_SubService");
//		ut.Verify_SubService_titlepage();
		s_assert.assertEquals(driver.getTitle(), Sub_ServicePageTitle);
		
		
		ut.select_self_onbehalf(i);
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
		ut.Postcode_SelectAddress(Sh_ClassV,1,2,3);	   // Parameter are Sheetname, excel filename & path, Row, Colunm1, Colunm2-Dropdown index value (Actual address)  			
		cv.Enter_FirstNameofdiplomat(Sh_ClassV,1,4);			
		cv.Enter_LastNameofdiplomat(Sh_ClassV,1,5);			
		ut.telphonenumber();
		ut.NEXT_2();   
		logger.log(LogStatus.INFO, "Customer View the Account Details page and Filled the details and clicked NEXT button ");
		
		//Application  details page			
		ut.MandatoryFieldCheck();				
		ut.selectdropdownvalue(cv.property_residence_Dpd, SelectbyIndex, "1");  //Is the property your main residence within the United Kingdom
		ut.selectdropdownvalue(cv.tenancy_agreement_Dpd, SelectbyIndex, "1");   //cd.Do you have a tenancy agreement forall of the property(); 			                    
		cv.EnterDate_residence_UK_diplomat(Sh_ClassV,1,8);   					//On what date did the property become the main residence in the UK of the diplomat					
		cv.Enter_Diplomatic_RankStatusPosition(Sh_ClassV,1,9);   				//Diplomatic rank, status or position			
		cv.Enter_CountryInternational_organisation(Sh_ClassV,1,10);     		//Country or international organisation conferring diplomatic rank, status or position	
		ut.selectdropdownvalue(cv.British_citizen_Dpd, SelectbyIndex, "1");  	//Is the diplomat any type of British subject or British citizen
		ut.selectdropdownvalue(cv.permanent_UK_resident_Dpd, SelectbyIndex, "1");  	//Is the diplomat a permanent UK resident	
		      		
		ut.NEXT_2();            //Application Details page next button			
		logger.log(LogStatus.INFO, "Customer View the Application Details page and Filled the details and clicked NEXT button ");
		
		ut.Uploadedocument();
		ut.NEXT_2();            //File Upload page		
	
		s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
		ut.Select_summons(0);
		ut.ClickCheckBox();
		Explicitwait(ut.Submit_btn__DeclarationPage,10);
		ut.ClickSubmit_btn();
		log4j_report.info("User clicked Submit button");
		logger.log(LogStatus.INFO, "Customer  clicked Submit button");
		
		s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
		String Service_Casenumber=ut.Casenumber(Casenumber);
		String AddScreenClassD=captureScrenshot(Screenshotname);	
		
		logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and Generated theCase number is: "+Service_Casenumber);
		
		ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassV,Service_Casenumber.substring(20, 30), 1, 1);
		
		logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassD));
		System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
		//logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassD));	
		ut.ClickGotohome_btn();
		s_assert.assertAll();
		System.out.println("Test Run Compleed ");
	}	

	//Delegation
	
	@Test (groups = {"Onbehalf_of_SomeOneElse"})
	public void Apply_onbehalfof_some_one_else() throws Exception 
	{		
		MyAccountCouncilTax_SubServices ct= new MyAccountCouncilTax_SubServices(driver);
		MyAccountClassV cv=new MyAccountClassV(driver);
		Utility ut=new Utility(driver);
		
		TestCasePass="Customer Selected Onbehalf of Some one else and Submitted case successfully";
		TestCaseFail="Customer is unable to Submit a case for Onbehalf of Some one else, 'Some thing went wrong' Please Check the Code";	
		TestCaseSkip="Test Case is Skipped for 'Submit a case for Onbehalf of Some one else' "; 
		String Casenumber=null;
		int i=1; // To Apply for onbehalf make i=1
		int j=2; //If 1 selects "This time only" option if 2 Selects "Indefinitely (until you advise us otherwise)"
		
		Explicitwait(hp.WhatSerivice_button,10);
		hp.Click_WhatSerivice();
		log4j_report.info("User clicked on What Service you are looking for");
		
		Explicitwait(hp.CouncilTax_linkbutton,10);
		hp.ClickonCounciltax();	
		log4j_report.info("User clicked on CouncilTax Service and CouncilTax Sub service Page is Opened ");
		logger.log(LogStatus.INFO, "Customer selected CouncilTax Service");
		
		Explicitwait(ct.ClassVServicelink,10);
		ct.ClickonclassVlink();	
		log4j_report.info("User clicked on ClassV SubService ");
		logger.log(LogStatus.INFO, "Customer selected ClassV Sub_SubService");
//		ut.Verify_SubService_titlepage();
		s_assert.assertEquals(driver.getTitle(), Sub_ServicePageTitle);
		
		ut.select_self_onbehalf(i);
			if(j==1)
			{
				ut.select_Authority_act(j);
				ut.Click_StartForm();
			
				s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
				ut.FirstNamedelegationTextbox(Sh_ClassV,1,11);
				ut.LastNamedelegationTextbox(Sh_ClassV,1,12);
				ut.AddressdelegationTextbox(Sh_ClassV,1,13,14);              // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
				logger.log(LogStatus.INFO, "Customer Added New delegation");
				ut.NEXT_2();
				logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : This time only) ");
			}
			else
			{
				ut.select_Authority_act(j);
				ut.tickdelegationcheckbox();
				ut.Click_StartForm();						
				s_assert.assertEquals(ut.Delegationheading(), Delegation_heading);
				ut.FirstNamedelegationTextbox(Sh_ClassV,1,11);
				ut.LastNamedelegationTextbox(Sh_ClassV,1,12);
				ut.AddressdelegationTextbox(Sh_ClassV,1,13,14);          // Parameter are Sheetname, excel filename & path, Row, Colunm, Dropdown index value (Actual address)  
				ut.NEXT_2();
				logger.log(LogStatus.INFO, "Customer selected OnBehalf of Some one else (Athourity to act : Indefinitly [until you advise us]) ");
				logger.log(LogStatus.INFO, "Customer Added New delegation");
			}
				
			//Account details page			
			s_assert.assertEquals(AccountDetails_heading, ut.Page_heading());						
			ut.MandatoryFieldCheck();
			ut.telphonenumber();
				
			ut.NEXT_2(); 					
			
			s_assert.assertEquals(AppDetails_heading, ut.Page_heading());
			ut.MandatoryFieldCheck();
			ut.selectdropdownvalue(cv.property_residence_Dpd, SelectbyIndex, "1");  //Is the property your main residence within the United Kingdom
			ut.selectdropdownvalue(cv.tenancy_agreement_Dpd, SelectbyIndex, "1");   //cd.Do you have a tenancy agreement forall of the property(); 			                    
			cv.EnterDate_residence_UK_diplomat(Sh_ClassV,1,8);   					//On what date did the property become the main residence in the UK of the diplomat					
			cv.Enter_Diplomatic_RankStatusPosition(Sh_ClassV,1,9);   				//Diplomatic rank, status or position			
			cv.Enter_CountryInternational_organisation(Sh_ClassV,1,10);     		//Country or international organisation conferring diplomatic rank, status or position	
			ut.selectdropdownvalue(cv.British_citizen_Dpd, SelectbyIndex, "1");  	//Is the diplomat any type of British subject or British citizen
			ut.selectdropdownvalue(cv.permanent_UK_resident_Dpd, SelectbyIndex, "1");  	//Is the diplomat a permanent UK resident	
			      		

			ut.NEXT_2();            //Application Details page next button			
			
			ut.Uploadedocument();
			ut.NEXT_2();            //File Upload page	
						
			
			s_assert.assertEquals(Support_Info_Declaration_heading, ut.Declarationheading());	
			ut.Select_summons(0);
			ut.ClickCheckBox();
			ut.ClickSubmit_btn();
			
			s_assert.assertEquals(ServiceSummary_heading, ut.Servicesummaryheading());
			String Service_Casenumber=ut.Casenumber(Casenumber);
			String AddScreenClassV=captureScrenshot(Screenshotname);	
			logger.log(LogStatus.INFO, "Customer uploads relevant documents and submits the case and Case number is genarated");
			logger.log(LogStatus.INFO, "Customer Submitted the Case successfully and "+Service_Casenumber);
			
			ExcelReadWrite.setCellData(Utility.excelfilepath,Sh_ClassV,Service_Casenumber.substring(20, 30), 1, 1);
			
			logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassV));
			logger.addScreenCapture(AddScreenClassV);
			System.out.println("CaseNumber: "+Service_Casenumber.substring(20, 30));
			//logger.log(LogStatus.PASS, logger.addScreenCapture(AddScreenClassD));	
			ut.ClickGotohome_btn();
			s_assert.assertAll();
			System.out.println("Test Run Compleed ");
		} 			
	
}
