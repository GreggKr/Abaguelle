package me.greggkr.abaguelle.commands.sub

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import me.greggkr.kdbf.command.commands
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import java.util.*

@CommandData("reftest")
class RefTestCommand : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        event.channel.sendMessage(Arrays.toString(commands.map { it.commandData.name }.toTypedArray())).queue()
    }
}