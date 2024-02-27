package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfCronograma {

   
	private static PdfPCell espacioBlanco(int anchoTotal) {
		PdfPCell cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(anchoTotal);
		return cell;
	}
 
	public static ByteArrayOutputStream pdfDetalleSoftware() throws DocumentException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, baos);
		document.open();        
		document.add(creaPDFDetalle()); 
	 // Cerrar el documento
	 document.close();

		return baos;
	}
	
	private static Element creaPDFDetalle() {
		final int AnchoTotal = 16;
		PdfPTable table = new PdfPTable(AnchoTotal);
		table.setTotalWidth(PageSize.A4.getWidth() - 20);

		table.setLockedWidth(true);
		// the cell object
		PdfPCell cell;
		// we add a cell with colspan 3

		cell = new PdfPCell(new Phrase("DETALLE SOFTWARE",
				FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(30);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

		cell.setColspan(10);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(
				obtenerFechaHoraActual(),
				FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(30);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

		cell.setColspan(4);
		table.addCell(cell);
		
		
		table.addCell(espacioBlanco(AnchoTotal));
		
		
		int ANCHO_TITULO = 2;
		
		table.addCell(titulo("TIPO",ANCHO_TITULO));
		
		table.addCell(titulo("DOMINIO",ANCHO_TITULO));
		
		table.addCell(titulo("DESCRIPCION",ANCHO_TITULO));
		
		table.addCell(titulo("ESTADO",ANCHO_TITULO));
		
		table.addCell(titulo("NOMBRE",ANCHO_TITULO));
		
		table.addCell(titulo("URLGIT",ANCHO_TITULO+1));
		
		table.addCell(titulo("SISTEMAINTEGRACION",ANCHO_TITULO+1));
		
		
		table.addCell(items("servireport.getTipo().toString()",ANCHO_TITULO));
		
		table.addCell(items("servireport.getDominio()",ANCHO_TITULO));
		
		table.addCell(items("servireport.getDescripcion()",ANCHO_TITULO));
		
		table.addCell(items(String.valueOf("servireport.getEstado()"),ANCHO_TITULO));
		
		table.addCell(items("servireport.getNombre()",ANCHO_TITULO));
		
		table.addCell(items("servireport.getUrlgit()",ANCHO_TITULO+1));
		
		table.addCell(items("servireport.getSistemaIntegracion()",ANCHO_TITULO+1));
		
		table.addCell(espacioBlanco(AnchoTotal));
		
//-----------------------BASE DE DATOS-----------------------------------------------------

		table.addCell(titulo("BASE DE DATOS ",AnchoTotal));
		
		table.addCell(titulo("Nombre base datos",AnchoTotal-8));
		
		table.addCell(titulo("version bd",AnchoTotal-8));

		for (int i = 0; i < 2; i++) {
			table.addCell(titulo("example1 ",AnchoTotal-8));
		
			table.addCell(titulo("example2",AnchoTotal-8));
		}

		//-----------------------LENGUAJES-----------------------------------------------------

		table.addCell(titulo("LENGUAJES ",AnchoTotal));

		table.addCell(titulo("NOMBRE",5));
		table.addCell(titulo("VERSION",5));
		table.addCell(titulo("DESCRIPCION",6));
		for (int i = 0; i < 2; i++) {
			table.addCell(titulo("YYYYY",5));
		
			table.addCell(titulo("vYY",5));
			table.addCell(titulo("YY",6));
		}
				//-----------------------PERSONAL-----------------------------------------------------

				table.addCell(titulo("PERSONAL ",AnchoTotal));

				table.addCell(titulo("DNI",2));
				table.addCell(titulo("TIPO",2));
				table.addCell(titulo("NOMBRE",2));
				table.addCell(titulo("APELLIDO",2));
				table.addCell(titulo("CORREOLABORAL",2));
				table.addCell(titulo("CORREO",2));
				table.addCell(titulo("ANEXO",2));
				table.addCell(titulo("CELULAR",2));
				for (int i = 0; i < 2; i++) {
					table.addCell(titulo("DNI",2));
					table.addCell(titulo("TIPO",2));
					table.addCell(titulo("NOMBRE",2));
					table.addCell(titulo("APELLIDO",2));
					table.addCell(titulo("CORREOLABORAL",2));
					table.addCell(titulo("CORREO",2));
					table.addCell(titulo("ANEXO",2));
					table.addCell(titulo("CELULAR",2));
				}
		//-----------------------AREAS-----------------------------------------------------

		table.addCell(titulo("AREAS ",AnchoTotal));

		table.addCell(titulo("TIPOA",3));
		table.addCell(titulo("NOMBRE",3));
		table.addCell(titulo("DESCRIPCION",10));
		for (int i = 0; i < 2; i++) {
			table.addCell(titulo("YYYYYY",3));
			table.addCell(titulo("YYYYYYYYYY",3));
			table.addCell(titulo("YYYYYYYYY",10));
		}




		return table;
		
		}
		public static String obtenerFechaHoraActual() {
	        // Obtiene la fecha y hora actual
	        Date fechaHoraActual = new Date();

	        // Define el formato deseado
	        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

	        // Formatea la fecha y hora
	        String fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual);

	        return fechaHoraFormateada;
	    }
		private static PdfPCell items(String mesanje, int cancolum) {
			PdfPCell cell = new PdfPCell(new Phrase(
					mesanje,
					FontFactory.getFont(FontFactory.HELVETICA, 8   )));
			// cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setColspan(cancolum);
			
			return cell;
		}
		private static PdfPCell titulo(String mesanje, int cancolum) {
			PdfPCell cell = new PdfPCell(new Phrase(
					mesanje,
					FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
			// cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	
			 cell.setFixedHeight(30);
			cell.setColspan(cancolum);
			
			return cell;
		}
	

}
