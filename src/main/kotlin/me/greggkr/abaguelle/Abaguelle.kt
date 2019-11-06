package me.greggkr.abaguelle

import me.greggkr.abaguelle.commands.InfoCommand
import me.greggkr.kdbf.startBot
import java.io.File

fun main() {
    val file = File("src/main/resources/config.json")
    startBot(file, listOf(InfoCommand()))
}