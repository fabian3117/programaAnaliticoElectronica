package com.example.demo.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/Resumenes")
/** Aca manejamos la entrega de los resumenes
 * Estaran en formato PDF y en local en este momento. Pero buena idea seria implementar con servidor FTP
 * TODO: SERVIDOR FTP para la entrega de archivos
 *
 */
public class Resumenes {
    @RequestMapping("/{id}")
    public ResponseEntity<byte[]> Descarga(@PathVariable String id) throws IOException {

        String resourceName="archivosPDF/"+id;
        ClassPathResource pdfFile = new ClassPathResource(resourceName);
        byte[] data = new byte[pdfFile.getInputStream().available()];
        pdfFile.getInputStream().read(data);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(data);
    }
}
