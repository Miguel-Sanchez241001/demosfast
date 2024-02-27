package com.example.demo;

import com.itextpdf.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
 
 
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class PdfController {
    @PostMapping("/exPdfPase")
    public ResponseEntity<byte[]> exportarPdfPase(HttpServletResponse response) throws IOException, DocumentException {

       

        // Llamar al generador de PDF para obtener el contenido del PDF en un ByteArrayOutputStream
        ByteArrayOutputStream baos = GeneratePdfCronograma.pdfDetalleSoftware();

        // Configurar encabezados adicionales de la respuesta HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "PASE_JUDICIAL.pdf");

        // Configurar la longitud del contenido en la respuesta
        headers.setContentLength(baos.size());

        // Devolver la respuesta con el contenido del PDF
        return ResponseEntity.ok().headers(headers).body(baos.toByteArray());
    }
}
