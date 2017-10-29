package com.small.business.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.small.business.model.people.People;
import com.small.business.model.people.Resume.PeopleResume;

public class FileParser {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileParser.class);

	private static final String MESSAGE_TYPE = "name";
	private static final String MESSAGE_CONTENT = "content";

	public static String parse(String filePath) {
		String extension = FilenameUtils.getExtension(filePath);
		if (extension.equalsIgnoreCase("txt")) {
			return parseTxtFile(filePath);
		} else if (extension.equalsIgnoreCase("doc")) {
			return parseDocFile(filePath);
		} else if (extension.equalsIgnoreCase("docx")) {
			return parseDocxFile(filePath);
		} else if (extension.equalsIgnoreCase("pdf")) {
			return parsePdfFile(filePath);
		} else {
			System.out.println("File format is not supported" + filePath);
		}
		return "";
	}

	public static String convertToArgonautFormat(String jsonPath) throws IOException {
			InputStream is = new FileInputStream(jsonPath);
			String content = IOUtils.toString(is);
			LOGGER.info("content: " + content);
			JSONObject messageContent = new JSONObject(content);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MESSAGE_TYPE, PeopleResume.class.getSimpleName());
			jsonObject.put(MESSAGE_CONTENT, messageContent);
			return jsonObject.toString();			
	}
	public static People migratePeopleResumeToPeople(PeopleResume peopleResume) {
		People peopleForImport = new People();
		if(peopleResume.getBasics().getName().getFirstName().length() > 0)
		{
			//full name
			String fullName = peopleResume.getBasics().getName().getFirstName() + 
					peopleResume.getBasics().getName().getMiddleName() + 
					peopleResume.getBasics().getName().getSurname();
			peopleForImport.setFullName(fullName);
		}
		//email
		if(peopleResume.getBasics().getEmail().size() > 0) {
			List<String> eMails = peopleResume.getBasics().getEmail();
			peopleForImport.setEmail(eMails.get(0));
			
		}
		//phone
		if(peopleResume.getBasics().getPhone().size() > 0) {
			List<String> Phones = peopleResume.getBasics().getEmail();
			peopleForImport.setEmail(Phones.get(0));
			
		}		
		//jobTitle
		peopleForImport.setJobTitle(peopleResume.getBasics().getTitle());
		//PeopleEducation
		/*List<PeopleHistory> listPeopleHistory = new ArrayList<PeopleHistory>();
		List<Experience> listExperience = new ArrayList<Experience>();
		if(listExperience.size() > 0) {
			for(Experience obj: listExperience) {
				PeopleHistory peopleHistory = new PeopleHistory();
				peopleHistory.setJobTitle(obj.getJobtitle());
				peopleHistory.setYearStarted(obj.getDate_start());
				peopleHistory.setYearEnd(obj.getDate_end());
				listPeopleHistory.add(peopleHistory);
			}
			
		}*/
		return peopleForImport;
	}
	private static String parsePdfFile(String filePath) {
		PDDocument pddDocument = null;
		try (InputStream inputStrm = new FileInputStream(filePath)) {
			pddDocument = PDDocument.load(inputStrm);
			PDFTextStripper textStripper = new PDFTextStripper();
			return textStripper.getText(pddDocument);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pddDocument != null) {
				try {
					pddDocument.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	private static String parseDocFile(String filePath) {
		try (InputStream inputStrm = new FileInputStream(filePath)) {
			HWPFDocument wordDoc = new HWPFDocument(inputStrm);
			return wordDoc.getText().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String parseDocxFile(String filePath) {
		try (InputStream fileInputStream = new FileInputStream(filePath)) {
			XWPFDocument docx = new XWPFDocument(fileInputStream);
			XWPFWordExtractor we = new XWPFWordExtractor(docx);
			return we.getText();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String parseTxtFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			StringBuilder builder = new StringBuilder();
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				builder.append(sCurrentLine);
				builder.append("\n");
			}
			return builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
