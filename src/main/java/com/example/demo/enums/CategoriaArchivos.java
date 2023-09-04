package com.example.demo.enums;

public enum CategoriaArchivos {
archivosPDF("archivosPDF/"),
archivosMarkdown("archivosMarkdown/");

private String valor;
    CategoriaArchivos(String valor) {
        this.valor=valor;
    }
    public String getValorAsociado() {
        return valor;
    }
}
