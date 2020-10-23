package com.example.enquetekotlin

import java.io.Serializable


class Terra : Serializable {
    var descricao: String? = null
    var caminho = 0
    var nome: String? = null

    constructor() {}
    constructor(nome: String?, descricao: String?, caminho: Int) {
        this.caminho = caminho
        this.descricao = descricao
        this.nome = nome
    }

}

