package me.greggkr.abaguelle.commands.`fun`

import me.greggkr.abaguelle.apis.getApod
import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import me.greggkr.kdbf.util.Emoji
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData("apod")
class ApodCommand : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        val apod = getApod()
        if (apod == null) {
            event.channel.sendMessage("${Emoji.X} Failed to get APOD.").queue()
        } else {
            event.channel.sendMessage(
                EmbedBuilder()
                    .setTitle("NASA Astronomy Picture of the Day")
                    .setImage(apod.hdUrl)
                    .setFooter("Taken: ${apod.date}, Copyright: ${apod.copyright}")
                    .build()
            ).queue()
        }
    }
}