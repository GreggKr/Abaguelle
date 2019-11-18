package me.greggkr.abaguelle

import com.oopsjpeg.osu4j.backend.Osu
import me.greggkr.kdbf.command.discoverCommands
import me.greggkr.kdbf.config
import me.greggkr.kdbf.startBot
import java.io.File

lateinit var osu: Osu

fun main() {
    discoverCommands("me.greggkr.abaguelle.commands")
    startBot(File("src/main/resources/config.json"))

    osu = Osu.getAPI(config["osu_token"] as String)

    hideConfigValues()
}

fun hideConfigValues() {
    config["osu_token"] = "hidden"
}