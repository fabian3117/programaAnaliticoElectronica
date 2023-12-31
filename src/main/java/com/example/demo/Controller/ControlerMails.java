package com.example.demo.Controller;

import com.example.demo.CorreoModelo;
import com.example.demo.enums.CategoriaArchivos;
import com.example.demo.manejoArchivos.Archivos;
import com.example.demo.utils.Generalidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;

/**
 * Este controlador se va a encargar de gestionar los envios de correo electronicos
 */
@RequestMapping("/Correos")
@Controller
//TODO Para evitar una saturacion analoga a ataque DDOS luego implementare seguridad con springboot security
public class ControlerMails {

@Autowired
    private final MailSenderConfig javaMailSender;
    @Autowired
    private final SpringTemplateEngine springTemplateEngine;

    public ControlerMails(MailSenderConfig javaMailSender, SpringTemplateEngine springTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.springTemplateEngine = springTemplateEngine;
    }


    /**
     * Metodo encargado del envio del correo con los datos adjuntos
     * @param id Identificador del archivo
     * @param correoModelo Datos para saber a quien enviar el correo
     * @throws MessagingException
     * @throws IOException
     * @throws MessagingException
     */
    @GetMapping("/{id}")
    @ResponseBody
    public void EnvioCorreo(@PathVariable String id,@ModelAttribute CorreoModelo correoModelo)throws MessagingException, IOException, MessagingException{

        Context context = new Context();
        String content = springTemplateEngine.process("templateMails", context);
        MimeMessage Mensaje = javaMailSender.mailSender().createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(Mensaje, true);
        helper.setFrom("GBA_Resoluciones@outlook.com.ar");
        //-->   Debug   <--
        helper.setSubject("Hola "+correoModelo.getNombre()+" Tus resumenes");
        helper.setTo(correoModelo.getCorreo());
        helper.setText("text");
        helper.setText(content, true);
        helper.addAttachment(Archivos.nameFilePDF(id), Archivos.obtainFile(CategoriaArchivos.archivosPDF,id));
        javaMailSender.mailSender().send(Mensaje);
    }
}
