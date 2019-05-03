package grouptwo.quizexam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import grouptwo.quizexam.data.ParamaterStatic;
import grouptwo.quizexam.model.Answer;
import grouptwo.quizexam.model.Question;
import grouptwo.quizexam.service.AnswerService;
import grouptwo.quizexam.service.QuestionService;

public class FileUtlis {

	public FileUtlis() {
		// TODO Auto-generated constructor stub
	}

	public static boolean DeleteFile(String filePath) {
		File file = new File(filePath);

		if (file.exists()) {
			file.delete();
			return true;
		}

		return false;
	}

	public static String createFoderUploadFile(HttpServletRequest request) {
		String appPath = request.getServletContext().getRealPath("");
		appPath = appPath.replace("\\", "/");

		// tạo thư mục tải lên
		String saveFullPath = null;
		if (appPath.endsWith("/")) {
			saveFullPath = appPath + ParamaterStatic.SAVE_DIRECTORY;

		} else {
			saveFullPath = appPath + "/" + ParamaterStatic.SAVE_DIRECTORY;

		}
		File fileSaveDir = new File(saveFullPath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		return saveFullPath;

	}

	public static String upLoadFile(HttpServletRequest request, String saveFullPath) {
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					String filePath = saveFullPath + File.separator + fileName;
					part.write(filePath);
					return filePath;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	private static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}

	public static boolean readAndWriteFileExcel(String filePath,int idCreator,int idSubject) throws IOException {
		Question question=null;
		Answer answer=null;
		
		
		DataFormatter fmt = new DataFormatter();
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		org.apache.poi.ss.usermodel.Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		try {
			while (iterator.hasNext()) {
				int idCurrentQus;
				question=new Question();
				question.setCreatorID(idCreator);
				question.setSubjectID(idSubject);
				
				
				/*Lấy từng hàng của sheet*/
				Row currentRow = iterator.next();
				
				
				/*Lấy tất cả cell của Hang*/
				Iterator<Cell> cellIterator = currentRow.cellIterator();
				
				
			/*	 getIdCategory câu h�?i 
				Cell cellIdCategory = cellIterator.next();
				System.out.println("id category câu h�?i là" + Integer.parseInt(fmt.formatCellValue(cellIdCategory)));*/
				
				
				/*get mức độ câu h�?i*/
				Cell cellLevel = cellIterator.next();
				question.setLevel((cellLevel+""));
				
				/* get câu h�?i */
				Cell cellQuestion = cellIterator.next();
				question.setQuestion(cellQuestion+"");
				System.out.println("câu h�?i là:" + cellQuestion);
				
				
				/*add câu h�?i vào database
				 */
				
				idCurrentQus=QuestionService.returnIdQuestionAfterInsert(question);
				
				if(idCurrentQus==-1)
				{
					return false;
				}
				question.setQuestionId(idCurrentQus);
				/* import câu trả l�?i */
				while (cellIterator.hasNext()) {
					answer=new Answer();
					Cell nextCell = cellIterator.next();
					
					
					
					Workbook book = currentRow.getSheet().getWorkbook();
					CellStyle style = nextCell.getCellStyle();
					int fontIndex = style.getFontIndex();
					Font font = book.getFontAt(fontIndex);
					
					/*them noi dung*/
					answer.setAnswer(nextCell+"");
					answer.setQuestionId(idCurrentQus);
					
					
					if (font.getBold()) {
						int idAns=AnswerService.returnIdAnsAfterInsert(answer);
						if(idAns==-1)
						{
							System.out.println("cau tra loi bi loi");
							return false;
						}
						question.setCorrectAnswerID(idAns);
						if(QuestionService.updateQuestion(question))
							{
							System.out.println("thêm câu tl đúng tc");
							}
						else return false;	
					} else {
						AnswerService.addAnswers(answer);
					}
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}
