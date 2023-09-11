package com.example.demo.Controller;

import com.example.demo.Entidades.Materias;
import com.example.demo.enums.CategoriaArchivos;
import com.example.demo.manejoArchivos.Archivos;
import com.example.demo.repository.MateriaRepo;
import com.example.demo.utils.Generalidades;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class ControlerPrincipal {
    @Autowired
    private MateriaRepo materia;


    @RequestMapping("")
  //  @ResponseBody
    public String Saludo(Model model){
        List<Materias> materias=materia.findAll();
        ArrayList<String> nombreMaterias = new ArrayList<>();
        materias.forEach(elemento ->{
        nombreMaterias.add(elemento.getNombreMateria());
        });
        model.addAttribute("elementos",nombreMaterias);
        model.addAttribute("materias",materias);
        return "principal";
    }

    /**
     * Adquisicion de los archivos markdown asociados
     * @param id : Identificador del archivo
     * @param model
     * @return
     * @throws IOException
     */
    @GetMapping("/lectura/{id}")
   // @ResponseBody
    public String Lectura(@PathVariable String id, Model model) throws IOException {
        ClassPathResource resource = Archivos.ObtenerPathArchivo(CategoriaArchivos.archivosMarkdown,id);
        Parser parser = Parser.builder().build();
        model.addAttribute("Titulo",id);
        if(resource.exists()){
            System.out.println("EXISTE");
            String markdownContent= StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
            Node document = parser.parse(markdownContent);
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            String htmlContent = renderer.render(document);
            model.addAttribute("htmlContent", htmlContent);
            return "testMarkdown";
        }
        else{
            System.out.println("No Existe");
            return "principal";
        }
    }
    @GetMapping("/inicializar")
    public String Inicializar(){
        ArrayList<String> strings= new ArrayList<>();
        strings.add("Álgebra y Geometría Analítica-11");
        strings.add("Análisis Matemático I-11");
        strings.add("Física I-11");
        strings.add("Informática I-11");
        strings.add("Ingeniería y Sociedad-11");
        strings.add("Química General-11");
        strings.add("Análisis Matemático II-21");
        strings.add("Física II-21");
        strings.add("Informática II-21");
        strings.add("Inglés I-21");
        strings.add("Diseño Asistido por Computadora-21");
        strings.add("Análisis de Señales y Sistemas-22");
        strings.add("Física Electrónica-22");
        strings.add("Probabilidad y Estadística-22");
        strings.add("Análisis de Señales y Sistemas-31");
        strings.add("Dispositivos Electrónicos-31");
        strings.add("Medios de Enlace-31");
        strings.add("Técnicas Digitales I-31");
        strings.add("Teoría de los Circuitos I-31");
        strings.add("Inglés II-31");
        strings.add("Electrónica Aplicada I-32");
        strings.add("Legislación-32");
        strings.add("Electrónica Aplicada II-41");
        strings.add("Máquinas e Instalaciones Eléctricas-41");
        strings.add("Medidas Electrónicas I-41");
        strings.add("Seguridad, Higiene y Medio Ambiente-41");
        strings.add("Sistemas de Comunicaciones-41");
        strings.add("Técnicas Digitales II-41");
        strings.add("Teoría de los Circuitos II-41");
        strings.add("Electrónica Aplicada III-51");
        strings.add("Electrónica de Potencia-51");
        strings.add("Medidas Electrónicas II-51");
        strings.add("Sistemas de Control-51");
        strings.add("Técnicas Digitales III-51");
        strings.add("Tecnología Electrónica-51");
        strings.add("Proyecto Final-61");
        strings.add("Economía-61");
        strings.add("Organización Industrial-61");
        strings.add("Materias Electivas-61");
        if(materia.findAll().isEmpty()){
            for(int i=0;i<strings.size();i++){
                Materias materias = getMaterias(strings, i);
                //materias.setAnio(strings.get(i).substring(strings.get(i).indexOf("-")+1,strings.get(i).indexOf("-")+2));
                materia.save(materias);
            }
        }

        return "redirect:/";
    }

    private static Materias getMaterias(ArrayList<String> strings, int i) {
        Materias materias=new Materias();
        materias.setNombreMateria(strings.get(i).substring(0, strings.get(i).indexOf("-")));
        String codigo= strings.get(i).substring(strings.get(i).indexOf("-")+1, strings.get(i).length());

        materias.setAnio(Character.getNumericValue(codigo.charAt(0)));

        materias.setCuatrimestre(Character.getNumericValue(codigo.charAt(1)));
        //-->   El link de los archivos por ahora pondre el mismo a todos   <---
        materias.setPrograma("info1.md");
        return materias;
    }
}
