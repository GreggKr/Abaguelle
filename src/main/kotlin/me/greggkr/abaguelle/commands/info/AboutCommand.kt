package me.greggkr.abaguelle.commands.info

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData("about")
class AboutCommand : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        event.channel.sendMessage(
            EmbedBuilder()
                .setDescription("Version 2 of the osu! discord bot Abaguelle.\nCreated by Gregg#1174")
                .addField(
                    "Open Source Links",
                    "[kdbf](https://github.com/GreggKr/kdbf)\n[Abaguelle](https://github.com/GreggKr/Abaguelle)",
                    true
                )
                .build()
        ).queue()
    }
}