package prof;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.pdf.PdfWriter;

public class Otchet1 {

	public static void build() {
		Document myPDFDoc = new Document(PageSize.A4);
		Font defFont = new Font(Font.HELVETICA, 8f, Font.NORMAL, Color.BLACK);
		FileOutputStream pdfOutputFile = null;
		try {
			pdfOutputFile = new FileOutputStream("sample1.pdf");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		final PdfWriter pdfWriter = PdfWriter.getInstance(myPDFDoc, pdfOutputFile);
		myPDFDoc.open();
		myPDFDoc.add(new Paragraph("Первый параграф"));
		myPDFDoc.add(new Paragraph(Chunk.NEWLINE));
		Paragraph p2 = new Paragraph("Я пришёл к тебе с приветом,\n" + "Рассказать, что солнце встало,\n"
				+ "Что оно горячим светом\n" + "По листам затрепетало;\n\n" + "Рассказать, что лес проснулся,\n"
				+ "Весь проснулся, веткой каждой,\n" + "Каждой птицей встрепенулся\n" + "И весенней полон жаждой;\n\n"
				+ "Рассказать, что с той же страстью,\n" + "Как вчера, пришёл я снова,\n"
				+ "Что душа всё так же счастью\n" + "И тебе служить готова;\n\n" + "Рассказать, что отовсюду\n"
				+ "На меня весельем веет,\n" + "Что не знаю сам, что буду\n" + "Петь — но только песня зреет.\n\n\n");
		myPDFDoc.add(p2);
		Table myTable = new Table(2);
		myTable.setCellsFitPage(true);
		myTable.setPadding(2f);
		myTable.setSpacing(0f);
		int[] w = { 1, 4 };
		myTable.setWidth(100f);
		myTable.setWidths(w);
		ArrayList<String> headerTable = new ArrayList<>();
		headerTable.add("№ по порядку");
		headerTable.add("ФИО");
		headerTable.forEach(e -> {
			Cell current = new Cell(new Phrase(e, defFont));
			current.setBackgroundColor(Color.LIGHT_GRAY);
			myTable.addCell(current);
		});
		Cell cell = new Cell(new Phrase(String.valueOf(1), defFont));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		myTable.addCell(cell);
		cell = new Cell(new Phrase("Иванов", defFont));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		myTable.addCell(cell);
		cell = new Cell(new Phrase(String.valueOf(2), defFont));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		myTable.addCell(cell);
		cell = new Cell(new Phrase("Петров", defFont));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		myTable.addCell(cell);
		cell = new Cell(new Phrase(String.valueOf(3), defFont));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		myTable.addCell(cell);
		cell = new Cell(new Phrase("Сидоров", defFont));
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		myTable.addCell(cell);
		myPDFDoc.add(myTable);
		myPDFDoc.close();
		pdfWriter.close();
	}
}
