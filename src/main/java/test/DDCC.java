package test;

import ca.uhn.fhir.context.FhirContext;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Composition.CompositionStatus;
import org.hl7.fhir.r4.model.Composition.DocumentConfidentiality;
import org.hl7.fhir.r4.model.Composition.SectionComponent;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent;
import org.hl7.fhir.r4.model.Immunization.ImmunizationStatus;
import org.hl7.fhir.r4.model.ImmunizationRecommendation;
import org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent;
import org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent;
import org.hl7.fhir.r4.model.InstantType;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.Narrative;
import org.hl7.fhir.r4.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.PositiveIntType;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;

public class DDCC {

	/**
	 * This is the Java main method, which gets executed
	 */
	public static void main(String[] args) {

		// Create a context
		FhirContext ctx = FhirContext.forR4();

		// Create a Bundle profile
		Bundle DDCCbundle = new Bundle();

		// Set logical id of this artifact
		DDCCbundle.setId("DDCCBundle");

		// Set metadata about the resource - Version Id, Last Updated Date, Profile
		Meta bundleMeta = DDCCbundle.getMeta();
		bundleMeta.setVersionId("1");
		bundleMeta.setLastUpdatedElement(new InstantType("2021-09-14T20:32:26.605+05:30"));
		bundleMeta.addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCDocument");

		// Set Confidentiality as defined by affinity domain
		bundleMeta.addSecurity(
				new Coding("http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "V", "very restricted"));

		// Set version-independent identifier for the Composition
		Identifier bundleIdentifier = DDCCbundle.getIdentifier();
		bundleIdentifier.setValue("");
		bundleIdentifier.setSystem("");

		// Set Bundle Type
		DDCCbundle.setType(BundleType.DOCUMENT);

		// Set Timestamp
		DDCCbundle.setTimestampElement(new InstantType("2021-09-14T20:32:26.605+05:30"));

		// Create a Composition profile
		Composition composition = new Composition();

		// Set logical id of this artifact
		composition.setId("Composition-01");

		Meta compositionMeta = composition.getMeta();
		compositionMeta.setVersionId("1");
		compositionMeta.setLastUpdatedElement(new InstantType("2021-09-14T20:32:26.605+05:30"));
		compositionMeta.addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCComposition");

		// Set language of the resource content
		composition.setLanguage("en-IN");

		// Plain text representation of the concept
		Narrative compositionText = composition.getText();
		compositionText.setStatus((NarrativeStatus.GENERATED));
		compositionText.setDivAsString("<div><p></p></div>");

		// Set version-independent identifier for the Composition
		Identifier compositionIdentifier = composition.getIdentifier();
		compositionIdentifier.setSystem("");
		compositionIdentifier.setValue("");

		// Status can be preliminary | final | amended | entered-in-error
		composition.setStatus(CompositionStatus.FINAL);
		composition.setSubject(new Reference().setReference("Patient/Patient-01"));
		composition.setDateElement(new DateTimeType("2021-09-14T20:46:09+05:30"));

		// Set author - Who and/or what authored the composition/DischargeSummary record
		composition.addAuthor(new Reference().setReference("Practitioner/Practitioner-01"));
		// Set confidentiality as defined by affinity domain
		composition.setConfidentiality(DocumentConfidentiality.N);

		// Set a Human Readable name/title
		composition.setTitle("WHO Digital Documentation of COVID-19 Certificates");

		// Patient Resource

		Patient patient = new Patient();
		patient.setId("Patient-01");
		patient.getMeta().setVersionId("1").setLastUpdatedElement(new InstantType("2021-09-09T14:58:58.181+05:30"))
				.addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCPatient");
		patient.getText().setStatus(NarrativeStatus.GENERATED)
				.setDivAsString("<div xmlns=\"http://www.w3.org/1999/xhtml\">ABC, 41 year, Male</div>");
		patient.addIdentifier()
				.setType(new CodeableConcept(
						new Coding("http://terminology.hl7.org/CodeSystem/v2-0203", "MR", "Medical record number")))
				.setSystem("").setValue("");
		patient.addName().setText("ABC");
		// use is mandatory
		patient.addName().setUse(NameUse.OFFICIAL);
		patient.addTelecom().setSystem(ContactPointSystem.PHONE).setValue("+919818512600").setUse(ContactPointUse.HOME);
		patient.setGender(AdministrativeGender.MALE).setBirthDateElement(new DateType("1985-01-12"));

		// Practitioner Resource
		Practitioner practitioner = new Practitioner();
		practitioner.setId("Practitioner-01");
		practitioner.getMeta().setVersionId("1").setLastUpdatedElement(new InstantType("2021-09-14T20:58:58.181+05:30"))
				.addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCPractitioner");

		practitioner.addName().setUse(NameUse.OFFICIAL);

		practitioner.addName().setText("Dr. DEF");

		// Organization Resource
		Organization organization = new Organization();
		organization.setId("Organization-01");
		organization.getMeta()
				.addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCOrganization");
		/*
		 * organization.getIdentifier() .add(new Identifier() .setType(new
		 * CodeableConcept( new Coding("http://terminology.hl7.org/CodeSystem/v2-0203",
		 * "PRN", "Provider number"))) .setSystem("").setValue(""));
		 */
		organization.setName("XYZ Lab Pvt.Ltd");
		
		DocumentReference  QRCode = new DocumentReference();
		QRCode.getMeta().addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCDocumentReferenceQR");
		QRCode.addContent().setFormat(new Coding(" ", "", "")).getAttachment().setContentType("").setData(null).setId("qrImage");
		
		QRCode.addContent().setFormat(new Coding(" ", "", "")).getAttachment().setContentType("").setData(null).setId("qrContent");
		QRCode.addContent().setFormat(new Coding(" ", "", "")).getAttachment().setContentType("").setData(null).setId("pdf");
		QRCode.setAuthenticator(new Reference().setReference("Organization/Organization-01"));
		 
		//  Immunization Resource
			Immunization immunization = new Immunization();
			immunization.getMeta().addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCImmunization");
			immunization.getMeta().setLastUpdatedElement(new InstantType("2021-09-14T20:58:58.181+05:30"))
					.setVersionId("1");
			immunization.getText().setStatus(NarrativeStatus.GENERATED);
			immunization.getText().setDivAsString(
					"<div xmlns=\"http://www.w3.org/1999/xhtml\"><p></p></div>");
			immunization.setStatus(ImmunizationStatus.COMPLETED);
			immunization.setVaccineCode(
					new CodeableConcept(new Coding("http://snomed.info/sct", "", "")));
			
			immunization.setPatient(new Reference().setReference("Patient/Patient-01"));
			immunization.setOccurrence(new DateTimeType("2021-09-14"));
			immunization.setLotNumber("BSCD12344SS");
			immunization.setPrimarySource(true);
			immunization.addPerformer().setActor(new Reference().setReference("Practitioner/Practitioner-01"));

		//  Immunization Recommendation Resource

			ImmunizationRecommendation immunizationRecommendation = new ImmunizationRecommendation();

			immunizationRecommendation.setPatient(new Reference().setReference("Patient/Patient-01"));
			immunizationRecommendation.setAuthority(new Reference().setReference("Organization/Organization-01"));
			immunizationRecommendation.setDateElement(new DateTimeType("2021-09-14T20:04:15.817-05:00"));
			immunizationRecommendation.getText().setStatus(NarrativeStatus.GENERATED);
			immunizationRecommendation.getText().setDivAsString(
					"<div xmlns=\"http://www.w3.org/1999/xhtml\"></div>");
			
			immunizationRecommendation.getMeta().addProfile("http://worldhealthorganization.github.io/ddcc/StructureDefinition/DDCCImmunizationRecommendation");
			ImmunizationRecommendationRecommendationComponent immnunizationRecommendationRecommendationComponent = new ImmunizationRecommendationRecommendationComponent();
			immnunizationRecommendationRecommendationComponent.addVaccineCode(
					new CodeableConcept(new Coding("http://snomed.info/sct", "", "")));
			immnunizationRecommendationRecommendationComponent.setForecastStatus(new CodeableConcept(
					new Coding("http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "due", "Due")));
			immnunizationRecommendationRecommendationComponent.setDescription("First sequence in protocol");
			immnunizationRecommendationRecommendationComponent.setSeries("Vaccination Series 1");
			immnunizationRecommendationRecommendationComponent.setDoseNumber(new PositiveIntType().setValue(1));
			immnunizationRecommendationRecommendationComponent.setSeriesDoses(new PositiveIntType(2));
			immnunizationRecommendationRecommendationComponent
					.addSupportingImmunization(new Reference().setReference("Immunization/Immunization-01"));
			ImmunizationRecommendationRecommendationDateCriterionComponent dateCreationComponet = new ImmunizationRecommendationRecommendationDateCriterionComponent();
			dateCreationComponet
					.setCode(new CodeableConcept(new Coding("http://loinc.org", "30980-7", "Date vaccine due")));
			dateCreationComponet.setValueElement(new DateTimeType("2021-05-10T00:00:00-05:00"));
			immnunizationRecommendationRecommendationComponent.addDateCriterion(dateCreationComponet);
			immunizationRecommendation.getRecommendation().add(immnunizationRecommendationRecommendationComponent);

	

			SectionComponent section1 = new SectionComponent();
			section1.setTitle("Immunization");
			section1.setCode(new CodeableConcept(new Coding("", "", ""))).
			addEntry(new Reference().setReference("Immunization/Immunization-01"));

			SectionComponent section2 = new SectionComponent();
			section2.setTitle("ImmunizationRecommendation");
			section2.setCode(new CodeableConcept(new Coding("", "", ""))).
			addEntry(new Reference().setReference("ImmunizationRecommendation/ImmunizationRecommendation-01"));

			SectionComponent section3 = new SectionComponent();
			section3.setTitle("Organization");
			section3.setCode(new CodeableConcept(new Coding("", "", ""))).
			addEntry(new Reference().setReference("Organization/Organization-01"));

			SectionComponent section4 = new SectionComponent();
			section4.setTitle("Practitionere");
			section4.setCode(new CodeableConcept(new Coding("", "", ""))).
			addEntry(new Reference().setReference("Practitioner/Practitioner-01"));
			
			SectionComponent section5 = new SectionComponent();
			section5.setTitle("Patient");
			section5.setCode(new CodeableConcept(new Coding("", "", ""))).
			addEntry(new Reference().setReference("Patient/Patient-01"));
			
			SectionComponent section6 = new SectionComponent();
			section6.setTitle("QR");
			section6.setCode(new CodeableConcept(new Coding("", "", ""))).
			addEntry(new Reference().setReference("QR/QR-01"));

			List<SectionComponent> sectionList = new ArrayList<SectionComponent>();
			sectionList.add(section1);
			sectionList.add(section2);
			sectionList.add(section3);
			sectionList.add(section4);
			sectionList.add(section5);
			sectionList.add(section6);
			composition.setSection(sectionList);
		

		// Set Custodian - Organization which maintains the composition
		composition.setCustodian(new Reference().setReference("Organization/Organization-01"));
		List<BundleEntryComponent> listBundleEntries = DDCCbundle.getEntry();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		BundleEntryComponent bundleEntry1 = new BundleEntryComponent();
		bundleEntry1.setFullUrl("Composition/Composition-01");
		bundleEntry1.setResource(composition);
		listBundleEntries.add(bundleEntry1);

		BundleEntryComponent bundleEntry2 = new BundleEntryComponent();
		bundleEntry2.setFullUrl("Practitioner/Practitioner-01");
		bundleEntry2.setResource(practitioner);
		listBundleEntries.add(bundleEntry2);

		BundleEntryComponent bundleEntry3 = new BundleEntryComponent();
		bundleEntry3.setFullUrl("Organization/Organization-01");
		bundleEntry3.setResource(organization);
		listBundleEntries.add(bundleEntry3);

		BundleEntryComponent bundleEntry4 = new BundleEntryComponent();
		bundleEntry4.setFullUrl("Patient/Patient-01");
		bundleEntry4.setResource(patient);
		listBundleEntries.add(bundleEntry4);
		
		BundleEntryComponent bundleEntry5 = new BundleEntryComponent();
		bundleEntry5.setFullUrl("Immunization/Immunization-01");
		bundleEntry5.setResource(immunization);
		listBundleEntries.add(bundleEntry5);
		
		BundleEntryComponent bundleEntry6 = new BundleEntryComponent();
		bundleEntry6.setFullUrl("ImmunizationRecommendation/ImmunizationRecommendation-01");
		bundleEntry6.setResource(immunizationRecommendation);
		listBundleEntries.add(bundleEntry6);
		
		BundleEntryComponent bundleEntry7 = new BundleEntryComponent();
		bundleEntry7.setFullUrl("QR/QR-01");
		bundleEntry7.setResource(QRCode);
		listBundleEntries.add(bundleEntry7);

		// Print the output
		String string = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(DDCCbundle);
		System.out.println(string);

	}

}
