package me.greggkr.abaguelle.commands.`fun`

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData("dabby")
class DabbyCommand : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        event.channel.sendMessage(
            EmbedBuilder()
                .setImage("https://cdn.discordapp.com/attachments/434004583300202497/508767853416284172/dabby.png")
                .build()
        ).queue()
    }
}