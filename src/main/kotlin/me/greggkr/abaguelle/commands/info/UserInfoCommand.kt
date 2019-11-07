package me.greggkr.abaguelle.commands.info

import me.greggkr.kdbf.command.Command
import me.greggkr.kdbf.command.CommandData
import me.greggkr.kdbf.util.getUserFromString
import me.greggkr.kdbf.util.prettyString
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

@CommandData("userinfo")
class UserInfoCommand : Command {
    override fun execute(event: MessageReceivedEvent, args: String?) {
        val ch = event.channel
        if (args.isNullOrEmpty()) {
            ch.sendMessage("Correct Usage: userinfo <user>").queue()
            return
        }

        val user = getUserFromString(event.message, args)
        if (user == null) {
            ch.sendMessage("User not found.").queue()
            return
        }

        val member = event.guild.getMember(user)

        ch.sendMessage(
            EmbedBuilder()
                .setTitle(user.prettyString())
                .setThumbnail(user.effectiveAvatarUrl)
                .setColor(member?.color)
                .addField("Nickname", member?.nickname ?: "None", true)
                .addField("Joined At", member?.timeJoined.toString(), true)
                .addField(
                    "Roles (${member?.roles?.size ?: 0})",
                    member?.roles?.joinToString(" ") { it.asMention } ?: "No Roles",
                    true)
                .setFooter("ID: ${user.id}")
                .build()
        ).queue()
    }
}