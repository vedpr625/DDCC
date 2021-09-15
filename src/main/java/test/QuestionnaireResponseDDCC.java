package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent;
import org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent;
import org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus;

import ca.uhn.fhir.context.FhirContext;

import org.hl7.fhir.r4.model.StringType;

public class QuestionnaireResponseDDCC {
	public static void main(String[] args) {
		FhirContext ctx = FhirContext.forR4();


	QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();
	questionnaireResponse.getMeta().addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCQuestionnaireResponse");
	questionnaireResponse.setStatus(QuestionnaireResponseStatus.COMPLETED);
	questionnaireResponse.setQuestionnaire("http://worldhealthorganization.github.io/ddcc/DDCCVSCoreDataSetQuestionnaire");
	questionnaireResponse.setSubject(new Reference().setReference("Patient/Patient-01"));
	questionnaireResponse.setAuthored(new Date());
	
	QuestionnaireResponseItemComponent qi = new QuestionnaireResponseItemComponent();
	qi.setLinkId("name").addAnswer().getValueStringType().setValue("Ved");
	
	QuestionnaireResponseItemComponent qi2 = new QuestionnaireResponseItemComponent();
	qi2.setLinkId("birthDate").addAnswer().getValueDateType().setValue(new Date());
	
	QuestionnaireResponseItemComponent qi3 = new QuestionnaireResponseItemComponent();
	qi3.setLinkId("identifier").addAnswer().getValueStringType().setValue("1234567890");
	
	QuestionnaireResponseItemComponent qi4 = new QuestionnaireResponseItemComponent();
	qi4.setLinkId("sex").addAnswer().getValueCoding().setCode("male").setSystem("http://hl7.org/fhir/administrative-gender");
	
	QuestionnaireResponseItemComponent qi5 = new QuestionnaireResponseItemComponent();
	qi5.setLinkId("vaccine").addAnswer().getValueCoding().setCode("XM1NL1").setSystem("http://id.who.int/icd11/mms");
	
	QuestionnaireResponseItemComponent qi6= new QuestionnaireResponseItemComponent();
	qi6.setLinkId("brand").addAnswer().getValueCoding().setCode("TEST").setSystem("http://worldhealthorganization.github.io/ddcc/CodeSystem/DDCC-Example-Test-CodeSystem");
	
	QuestionnaireResponseItemComponent qi7 = new QuestionnaireResponseItemComponent();
	qi7.setLinkId("manufacturer").addAnswer().getValueCoding().setCode("TEST").setSystem("http://worldhealthorganization.github.io/ddcc/CodeSystem/DDCC-Example-Test-CodeSystem");
	
	QuestionnaireResponseItemComponent qi8 = new QuestionnaireResponseItemComponent();
	qi8.setLinkId("ma_holder").addAnswer().getValueCoding().setCode("TEST").setSystem("http://worldhealthorganization.github.io/ddcc/CodeSystem/DDCC-Example-Test-CodeSystem");
	
	QuestionnaireResponseItemComponent qi9 = new QuestionnaireResponseItemComponent();
	qi9.setLinkId("lot").addAnswer().getValueStringType().setValue("ER8732");
	
	QuestionnaireResponseItemComponent qi10 = new QuestionnaireResponseItemComponent();
	qi10.setLinkId("date").addAnswer().getValueDateType().setValue(new Date());
	
	QuestionnaireResponseItemComponent qi11 = new QuestionnaireResponseItemComponent();
	qi11.setLinkId("vaccine_valid").addAnswer().getValueDateType().setValue(new Date());
	
	QuestionnaireResponseItemComponent qi12 = new QuestionnaireResponseItemComponent();
	qi12.setLinkId("dose").addAnswer().getValueIntegerType().setValue(1);
	
	QuestionnaireResponseItemComponent qi14 = new QuestionnaireResponseItemComponent();
	qi14.setLinkId("total_doses").addAnswer().getValueIntegerType().setValue(2);
	
	QuestionnaireResponseItemComponent qi15 = new QuestionnaireResponseItemComponent();
	qi15.setLinkId("country").addAnswer().getValueCoding().setCode("USA").setSystem("urn:iso:std:iso:3166");
	
	QuestionnaireResponseItemComponent qi16 = new QuestionnaireResponseItemComponent();
	qi16.setLinkId("centre").addAnswer().getValueStringType().setValue("Vaccination Site");
	
	QuestionnaireResponseItemComponent qi17 = new QuestionnaireResponseItemComponent();
	qi17.setLinkId("hw").addAnswer().getValueStringType().setValue("lAH8TnzqAInqwkslHzOlSA");
	
	QuestionnaireResponseItemComponent qi18 = new QuestionnaireResponseItemComponent();
	qi18.setLinkId("disease").addAnswer().getValueCoding().setCode("RA01").setSystem("http://id.who.int/icd11/mms");
	
	QuestionnaireResponseItemComponent qi19 = new QuestionnaireResponseItemComponent();
	qi19.setLinkId("due_date").addAnswer().getValueDateType().setValue(new Date());
	
	QuestionnaireResponseItemComponent qi20 = new QuestionnaireResponseItemComponent();
	qi20.setLinkId("pha").addAnswer().getValueStringType().setValue("dPD2PfwzBQyphcjeUiAdRP");
	
	QuestionnaireResponseItemComponent qi21 = new QuestionnaireResponseItemComponent();
	qi21.setLinkId("hcid").addAnswer().getValueStringType().setValue("bMlJkAt0V92RYhhG3fNt");
	
	QuestionnaireResponseItemComponent qi22 = new QuestionnaireResponseItemComponent();
	qi22.setLinkId("valid_from").addAnswer().getValueDateType().setValue(new Date());
	
	QuestionnaireResponseItemComponent qi23 = new QuestionnaireResponseItemComponent();
    qi23.setLinkId("valid_until").addAnswer().getValueDateType().setValue(new Date());
	
	questionnaireResponse.addItem(qi);
	questionnaireResponse.addItem(qi2);
	questionnaireResponse.addItem(qi3);
	questionnaireResponse.addItem(qi4);
	questionnaireResponse.addItem(qi5);
	questionnaireResponse.addItem(qi6);
	questionnaireResponse.addItem(qi7);
	questionnaireResponse.addItem(qi8);
	questionnaireResponse.addItem(qi9);
	questionnaireResponse.addItem(qi10);
	questionnaireResponse.addItem(qi11);
	questionnaireResponse.addItem(qi12);
	questionnaireResponse.addItem(qi14);
	questionnaireResponse.addItem(qi15);
	questionnaireResponse.addItem(qi16);
	questionnaireResponse.addItem(qi17);
	questionnaireResponse.addItem(qi18);
	questionnaireResponse.addItem(qi19);
	questionnaireResponse.addItem(qi20);
	questionnaireResponse.addItem(qi21);
	questionnaireResponse.addItem(qi22);
	questionnaireResponse.addItem(qi22);
	
	// Print the output
			String string = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(questionnaireResponse);
			System.out.println(string);

	

	}

}
