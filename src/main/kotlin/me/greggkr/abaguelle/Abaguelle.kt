package me.greggkr.abaguelle

import me.greggkr.kdbf.command.discoverCommands
import me.greggkr.kdbf.startBot
import java.io.File

fun main() {
    discoverCommands("me.greggkr.abaguelle.commands")
    startBot(File("src/main/resources/config.json"))
}