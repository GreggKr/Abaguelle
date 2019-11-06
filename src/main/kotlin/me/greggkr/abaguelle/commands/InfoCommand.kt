package me.greggkr.abaguelle.commands

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData(
    name = "info"
)
class InfoCommand : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        event.channel.sendMessage(
            EmbedBuilder()
                .setDescription("Version 2 of the osu! discord bot Abaguelle.\nCreated by Gregg#1174")
                .build()
        ).queue()
    }
}