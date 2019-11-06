package me.greggkr.abaguelle

import me.greggkr.abaguelle.commands.AboutCommand
import me.greggkr.abaguelle.commands.DabbyCommand
import me.greggkr.kdbf.startBot
import java.io.File

fun main() {
    val file = File("src/main/resources/config.json")
    startBot(file, listOf(AboutCommand(), DabbyCommand()))
}