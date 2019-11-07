package me.greggkr.abaguelle.commands.`fun`

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData(
    name = "big",
    triggers = ["bigemoji"]
)
class BigCommand : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        val emotes = event.message.emotes
        if (emotes.isEmpty()) {
            event.channel.sendMessage("Correct Usage: big <emote>").queue()
            return
        }

        event.channel.sendMessage(
            EmbedBuilder()
                .setImage(emotes[0].imageUrl)
                .build()
        ).queue()
    }
}